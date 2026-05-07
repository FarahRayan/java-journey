import java.util.Scanner;

public class PrintWelcome{
    public static void main(String[] args) {
stor();
names();
    }
    public static void stor(){
        int[] arr= new int[5];

        System.out.println("please enter 5 num ");
        Scanner input = new Scanner(System.in);

        for (int i =0 ;i<5 ; i++){
arr[i] = input.nextInt();

        }
        for (int i = 0; i < 5; i++) {

            System.out.println(arr[i]);

    }
}
public static void names(){
        String[] name = new String[5];
        Scanner in = new Scanner(System.in);
    System.out.println("please enter 5 names ");
    for (int i  =0; i<5 ; i++){
        name[i] = in.nextLine();
    }
    for (int i =0; i<5 ;i++){
        System.out.println(name[i]);
    }
}
}









/*
public class PrintWelcome{
    public static void main(String[] args) {
        printWelcome();
        int result = subtract(9 ,5);
        System.out.println(result);
        double resultDivide  = divide(9,0);
        System.out.println(resultDivide );
        boolean result1 = isPositive(-7);
        System.out.println(result1);
        String result2 = getGrade(80);
        System.out.println(result2);
        int result3 = sumUpTo(8);
        System.out.println(result3);

        int [] scores = {2 ,3,4,5};

    }

    public static void printWelcome(){
        System.out.println("java");
    }
    public static int subtract(int a, int b){
return a - b;
    }
    public static double divide(double a, double b){
        if (b ==0){

            return 0;


        }
        return a / b;
    }
    public static boolean isPositive(int n){
        if (n > 0){
            return true;
        } else {
            return false;
        }
    }

    public static String getGrade(int score){
        if (score>90&& score<100){
            return "A";
        }
        else if (score<90 && score >80){
            return "B";

        }
else return "c";
    }


    public static int sumUpTo(int n){
        int sum = 0;
        for (int i=0 ; i<= n ; i++){
            sum = sum + i;
        }
        return sum;
    }
}  */