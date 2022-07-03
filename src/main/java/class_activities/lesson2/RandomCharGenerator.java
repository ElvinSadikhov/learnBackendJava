package class_activities.lesson2;

import java.util.Random;
import java.util.Scanner;

public class RandomCharGenerator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Please enter the max number of iterations: ");
        int maxIterNum = in.nextInt();

        char curChar;
        for(int i = 0; i < maxIterNum; i++) {
            curChar = (char) (rand.nextInt('Z' - 'A' + 1) + 'A');
            if(curChar == 'A' || curChar == 'I') {
                System.out.println("\n" + (char) curChar + " is either 'A' or 'I'");
                break;
            }
            System.out.print((char) curChar + " ");
        }
    }

}
