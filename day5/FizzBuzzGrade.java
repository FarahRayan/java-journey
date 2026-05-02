import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class FizzBuzzGrade {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
                /*
int x = 0;
   System.out.println("enter:");
   x = input.nextInt();
if (x %2 ==0){
    System.out.println("even") ;

}

else {
    System.out.println("odd");
}




*/
        System.out.println("FizzBuzz");
        for (int i = 1; i <=50 ; i++){
            if(i%3== 0 && i%5== 0){
                System.out.println("FizzBuzz");
            }
            else if (i %3==0){
                System.out.println("fizz");
            }
            else if (i % 5==0){
                System.out.println("buzz");
            }
            else {
                System.out.println(i);
            }
        }

        System.out.println("plz enter your score :");
        int score = input.nextInt();
        if (score> 100 || score< 0){
            System.out.println("invalid score ");
            return;
        }
 switch (score/ 10){
    case 10:
    case 9:
        System.out.println("A");
        break;
    case 8:
        System.out.println("B");
        break;
    case 7:
        System.out.println("C");
        break;
    case 6:
        System.out.println("D");
break;
    default :
        System.out.println("f");

};

    }

}


