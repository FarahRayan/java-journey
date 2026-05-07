import java.util.Scanner;

public static void main(String[]args){

    System.out.println(add(5, 3));
    System.out.println(multiply(4, 6) );
    System.out.println(isEven(7));
    System.out.println(factorial(5));

}

    public static int add(int a, int b){
    return a + b;
}

public static int multiply (int a, int b){
    return a * b;
}

  public static boolean isEven(int n)  {

        return n %2==0;
    }
public static int factorial(int n){
    if (n == 0) return 1;
     return n * factorial(n - 1);
}





