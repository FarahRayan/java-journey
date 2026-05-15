import java.util.Scanner;

public class BankVault {
    static Scanner input = new Scanner(System.in);
    // ===== CONFIG =====
    static final int MAX_ACCOUNTS = 10;
    // ===== DATA =====
    static String[] accountNumbers = new String[MAX_ACCOUNTS];
    static String[] ownerNames = new String[MAX_ACCOUNTS];
    static String[] pins = new String[MAX_ACCOUNTS];
    static double[] balances = new double[MAX_ACCOUNTS];
    static String[] accountTypes = new String[MAX_ACCOUNTS];
    static final int MAX_TRANSACTIONS = 20;
    static final String ADMIN_PIN = "9999";
    static final double DAILY_WITHDRAW_LIMIT = 2000.0;
    static String[][] transactions   = new String[MAX_ACCOUNTS][MAX_TRANSACTIONS];
    static int[] transactionCounts   = new int[MAX_ACCOUNTS];

    static boolean[] isLocked        = new boolean[MAX_ACCOUNTS];
    public static void main(String[] args) {
seedAccounts();

        int loggedIn = login();

        if (loggedIn != -1){
            System.out.println("Welcome " + ownerNames[loggedIn]);
        }
        printDivider();
        printAllAccounts();

        if (adminLogin()){
            System.out.println("Admin access");
        } else {
            System.out.println("Wrong pin");
        }

    }


    static int accountCount = 1;   //to declaer the account numbers
    static void seedAccounts(){
        accountNumbers[0]= "BV-0001";
        ownerNames[0] = "Farah Salem";
        pins[0] = "1234";
        balances[0] =5000.00; //without double cotation
        accountTypes[0] = "Savings";

        accountNumbers[1] = "BV-0002";
        ownerNames[1] = "Omar";
        pins[1] = "4567";
        balances[1] = 1200.50;
        accountTypes[1] = "Checking";

        accountNumbers[2] = "BV-0003";
        ownerNames[2] = "Sara";
        pins[2] = "7890";
        balances[2] = 8750.00;
        accountTypes[2] = "Savings";

        accountNumbers[3] = "BV-0004";
        ownerNames[3] = "Ali";
        pins[3] = "2222";
        balances[3] = 300.00;
        accountTypes[3] = "Checking";

        accountCount = 4;

    }
    static String generateAccountNumber(){
int nextNum = accountCount +1;

return "BV-" +String.format("%04d",nextNum);
    }

    static void printDivider(){
        System.out.println("======================================================");
    }

    static int findAccount(String accountNumber){
        for (int i = 0; i < accountCount ;i++){
            if (accountNumbers[i].equals(accountNumber)){
                return i;
            }

        }  return -1;
    }

    static boolean validatePin(int accountIndex, String enteredPin){
if (pins[accountIndex].equals(enteredPin)){
    return true;
}
return false;
    }

    static boolean isValidAmount(double amount){

        if (amount > 0.0){
            return true;
        }
        return false;
    }



    static int login(){

        System.out.println("Enter your number");
        String number = input.nextLine();
        int index = -1;  // if false still -1
           for (int i =0 ; i< accountCount ;i++){
                if (accountNumbers[i].equals(number)){
                       index =i;
                       break;
                }}
           if (index== -1){
               System.out.println("incorrect number!!!");
               return -1;
           }

        if (isLocked[index]){
            System.out.println("your account is locked");
            return -1;

        }
        int attempts = 0;
        do{
            System.out.println("Enter your pin");
            String enteredPin= input.nextLine();


               if (validatePin(index, enteredPin)){
                   System.out.println("Login successful");
                   return index;
               } else {
                   attempts++;

                   System.out.println("Incorrect pin");
               }
               }
               while (attempts < 3);

            isLocked[index] = true;

            System.out.println("Account locked after 3 failed attempts");

            return -1;
        }
    static boolean adminLogin(){
        System.out.println("enter admin pin");
        String adminPin  = input.nextLine();

if (adminPin.equals(ADMIN_PIN)){
    return true;
}
return false;
}
    static void deposit(int accountIndex){
        System.out.println("enter amount");
        double amount = Double.parseDouble(input.nextLine());


        if (isValidAmount(amount)){
            balances[accountIndex] += amount;
            System.out.println("successful");
            System.out.println("your new balanc :" + balances[accountIndex]);
        }
        else {
            System.out.println("Invalid amount");

        }
    }
    static void withdraw(int accountIndex){
        System.out.println("enter amount");
        double amount = Double.parseDouble(input.nextLine());
        if (isValidAmount(amount)){
            if (amount <= balances[accountIndex]){
                if (amount <= DAILY_WITHDRAW_LIMIT){
                    balances[accountIndex]-= amount;
                }
            }
        }
        else {
            System.out.println("invalid");
        }
    }
    static void transfer(int senderIndex){
        System.out.println("enter recever account");
        String destinationNumber  =input.nextLine();

        int receiverIndex = findAccount(destinationNumber);
        if (receiverIndex == -1){

            System.out.println("account not found");
            System.out.println("Enter amount");
            double amount = Double.parseDouble(input.nextLine());

            if (!isValidAmount(amount)){
                System.out.println("invalid");
            }
            if (amount > balances[senderIndex]){
                System.out.println("Insufficient balance");
                return;
            }

            balances[senderIndex] -= amount;
            balances[receiverIndex] += amount;

            System.out.println("Transfer successful");
            System.out.println("Sent: " + amount);
            System.out.println("New balance: " + balances[senderIndex]);
        }
        }
    static void recordTransaction(int accountIndex, String type, double amount){
        String record = String.format("%+.2f | %s", amount, type);

        int index = transactionCounts[accountIndex];

        transactions[accountIndex][index] = record;
        transactionCounts[accountIndex]++;

        if (transactionCounts[accountIndex] >= MAX_TRANSACTIONS){

            for (int i = 1; i < MAX_TRANSACTIONS; i++){
                transactions[accountIndex][i - 1] =
                        transactions[accountIndex][i];
            }

            transactionCounts[accountIndex] = MAX_TRANSACTIONS - 1;
        }
    }
    static void printStatement(int accountIndex){
        if (transactionCounts[accountIndex]==0){
            System.out.println("No transactions yet");
        }
        else {
            for (int i =0 ;i <transactionCounts[accountIndex] ;i++ ){
                System.out.println(transactions[accountIndex][i]);
            }
        }
    }
    static double calculateCompoundInterest(double principal, double rate, int years){
        if (years == 0){
            return principal;
        }
        return calculateCompoundInterest(

                principal * (1 + rate), rate , years -1
        );
    }
    static void futureValueMenu(int accountIndex){
        System.out.println("How many years to project?");
        int years = input.nextInt();

        double rate =0.05;
        double balance = balances[accountIndex];

        for ( int i =0; i <= years ;i++){
        double future= calculateCompoundInterest(balance, rate, i);
            System.out.println(  i + future);
        }

    }
    static void printAllAccounts() {
        for (int i=0 ; i< accountCount ; i++){
            System.out.println(accountNumbers[i]+
                    ownerNames[i]+
                    pins[i]+
                    balances[i]+
                    accountTypes[i]

            );

        }
    }
    static int findHighestBalance(){
        int highest = 0;
        for (int i =0; i< accountCount ;i++){
            if (balances[i]> balances[highest]){
                 highest=i;
            }

        }
        return highest;
    }
    static int findLowestBalance(){
        int loewst =0;
        for (int i =0; i<accountCount ;i++){

                if (isLocked[i]){
                continue;
                }
            if (balances[i]<balances[loewst]){
                loewst =i;
            }
        }
        return loewst;
    }
    static double calculateTotalAssets(){
        double total =0;
        for (int i =0 ; i< accountCount ;i++){
            total = total +balances[i];
        }
        return total;
    }
    static double calculateAverageBalance(){
        double sum = 0.0;
        int active = 0;        for (int i =0 ; i< accountCount ;i++){
            if (isLocked[i]){
                continue;
            }
            sum += balances[i];
            active++;
        }
        return sum/ active;
    }
    static void printBankReport(){

        System.out.println(accountCount);
        System.out.println(calculateTotalAssets());
        System.out.println(calculateAverageBalance());
    }
    static void addAccount(){

        if (accountCount >= MAX_ACCOUNTS){
            System.out.println("Bank is full.");
            return;
        }

           System.out.println("Enter owner name");
        String name = input.nextLine();
        System.out.println("Enter PIN:");
            String pin = input.nextLine();

        System.out.println("Enter account type ");
        String type = input.nextLine();

        String accNumber = generateAccountNumber();
        accountNumbers[accountCount] = accNumber;
        ownerNames[accountCount] = name;
         pins[accountCount] = pin;
        balances[accountCount] = 0.0;
          accountTypes[accountCount] = type;

        accountCount++;
        System.out.println("Account " + accNumber + " created successfully.");
    }

    static void adminMenu(){

        while(true){

            System.out.println("ADMIN PANEL");
            System.out.println("1 View all accounts");
            System.out.println("2 Richest and poorest");
            System.out.println("3 Full bank report");
            System.out.println("4 Add account");
            System.out.println("0 Back");

            String choice = input.nextLine();

            switch(choice){

                case "1":
                    printAllAccounts();
                    break;



                case "3":
                    printBankReport();
                    break;

                case "4":
                    addAccount();
                    break;

                case "0":
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    static void userMenu(int index){
        while(true){
        System.out.println("[1] Check Balance");
        System.out.println("[2] Deposit");
        System.out.println("[3] Withdraw");
        System.out.println("[4] Transfer to another account");
        System.out.println("[5] View Statement");
        System.out.println("[6] Calculate future value");
        System.out.println("[0] Logout");
        String choice = input.nextLine();

        switch (choice){
            case "2":
                deposit(index);
break;

                case "3":
                    withdraw(index);
                    break;

                case "4":
                    transfer(index);
                    break;

                case "5":
                    printStatement(index);
                    break;

                case "6":
                    futureValueMenu(index);
                    break;
            };
        }
    }}





