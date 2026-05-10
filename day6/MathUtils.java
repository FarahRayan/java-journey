import java.util.Scanner;

public static void main(String[]args){

    System.out.println(add(5, 3));
    System.out.println(multiply(4, 6) );
    System.out.println(isEven(7));
    System.out.println(factorial(5));

    System.out.println(isPrime(7));
    System.out.println(isPrime(10));

    System.out.println(fibonacci(10));

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
public static boolean isPrime(int n) {
    if(n<=1){
        return false;
    }
    for (int i =2 ;i<n ;i++){ //declaration i =2 for testing
if (n % i==0){
    return false;
}
    }
    return true;
}
public static int fibonacci(int n){
if ( n==0){
    return 0;
    }
if (n==1){
    return 1;
}
return (fibonacci(n-1)+fibonacci(n-2));
}





