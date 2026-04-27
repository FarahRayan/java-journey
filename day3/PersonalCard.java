import java.util.Scanner;

public class PersonalCard {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.println("enter your age");
        int age = input.nextInt();

        System.out.println("  Developer Card");

        System.out.println("  Name    : " + name);
System.out.println("age :" + age);


    }

}


