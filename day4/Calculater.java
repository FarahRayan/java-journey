import java.sql.SQLOutput;
import java.util.Scanner;

public class Calculater {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
/* int x = 1 , y;
y = ++x;
System.out.println(y);
        int k = 5;
        k = k + 10;
        k += 10;*/
        System.out.println("Enter equation");
        String equation = input.nextLine();
        String[] parts = equation.split(" ");
   double num1 =Double.parseDouble(parts[0]);
   String op = parts[1];
Double num2 = Double.parseDouble(parts[2]);
        double result = 0;

        switch (op){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 + num2;
                break;
            case  "*":
                result = num1 * num2;
                break;

            case "/":
                result = num1 / num2;
                break;

        }
        System.out.println("Result = " + result);


    }
}