package class_activities.lesson1;

import java.util.Scanner;

public class PrimitiveTypes {

    public static void main(String[] args) {

        boolean boolObj = true; // can be true-false / 1-0
        byte byteObj = 32; // integers that can fit in 1 byte(-128..127)
        short shortObj = 111; // 2 bytes
        int intObj = 12121; // integers that can fit in 4 bytes
        long longObj = 112121023430l; //  fit in 8 bytes
        float floatObj = 12.32f; // must write f at the end, 4 bytes
        double doubleObj = 2.3; // 8 bytes
        char charObj = 'a'; // characters must be written inky using single-quotas

        double num1 = 23.2;
        double num2 = 43.2;
        double sum = num1 + num2;

        System.out.println(sum);


        // casting
        // Java has 2 types of casting: Automatic(from smaller to bigger) and manual(from bigger to smaller)
        // manual can result in problems and data loss

        short shortNum = 1223;
        byte byteNum = (byte) shortNum; // like moving from 00000000 11111111 to 11111111 as byte stores only 1 byte

        System.out.println(byteNum);

        Scanner in = new Scanner(System.in);

        System.out.println("Enter an integer number: ");
        int num = Integer.parseInt(in.nextLine()); // next() will read only until first space!

        System.out.println(num);
    }

}
