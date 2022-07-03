package class_activities.lesson2;

import java.util.Arrays;

public class ArraysLesson {

    public static void main(String[] args) {
        // all 3 lines are the correct ways of initializing arrays in Java
        int []arr1;
        int[] arr2;
        int arr3[];

        String strArr[] = new String[10];  // will create array of String with length 10(empty for now)
        byte[] byteArr = {1, 2, 3, 4, 5};

        strArr[0] = "first";
        strArr[1] = "second";
        strArr[9] = "last";

        for (String chr: strArr) {
            System.out.println(chr);
        }

        System.out.println("The length of byteArr is: " + byteArr.length);

        Arrays.sort(byteArr);
        System.out.println("Sorted byteArr: ");
        for (byte num: byteArr) {
            System.out.println(num);
        }

        Arrays.fill(strArr, "filled value");
//        System.arraycopy();

        for (String str: strArr)
            System.out.println(str);

        // 2 dimensional arrays (2D)
        int[][] twoDimenArr = {{1, 2}, {3, 4}};


    }
}
