
import java.util.Scanner;

public class StudentScoreAnalyzer {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        String[] names = new String[5];
        int[] scores = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("plz enter your name");
            names[i] = input.nextLine();

            System.out.println("plz enter your scores num");
            scores[i] = input.nextInt();
            input.nextLine(); // new line

        }
        for (int i = 0; i < 5; i++) {
            System.out.println(names[i] + " : " + scores[i] + ":" + getGrade(scores[i])); // to print

        }

        System.out.println("avg " + calculateAverage(scores));
        System.out.println("hight " + findHighest(scores));
          System.out.println("lowest " + findLowest(scores));


    }

    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum = sum + scores[i];
        }
        return sum / scores.length;
    }

    public static int findHighest(int[] scores) {
        int hight = scores[0];
        for (int i = 0; i < 5; i++) {
            if (scores[i] > hight) {
                hight = scores[i];
            }

        }
        return hight;
    }

    public static int findLowest(int[] scores) {
        int low = scores[0];
        for (int i = 0; i < 5; i++) {
            if (scores[i] < low) {
                low = scores[i];
            }
        }
        return low;
    }

    public static String getGrade(int scores) {
        for (int i = 0; i < 5; i++) {
            if (scores < 100 && scores > 90) {
                return "A";
            } else if (scores < 90 && scores > 80) {
                return "B";

            } else if (scores < 80 && scores > 70) {
                return "C";
            } else if (scores < 70 && scores > 60) {
                return "D";

            } else {

            }

        }
        return "F";
    }
}