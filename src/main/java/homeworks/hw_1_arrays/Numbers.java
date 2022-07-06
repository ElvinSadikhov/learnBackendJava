package homeworks.hw_1_arrays;

import java.util.Random;
import java.util.Scanner;

public class Numbers {

    private static String getUserName() {
        Scanner in = new Scanner(System.in);
        String name;

        while(true) {
            System.out.println("Please enter your name in order to start:");
            name = in.nextLine();
            if(!name.isEmpty()) {
                return name;
            }
        }
    }

    private static int getValidIntNumber() {
        Scanner in = new Scanner(System.in);

        while(true) {
            String userInput = in.nextLine().trim();

            if(isPositiveInteger(userInput)) {
                return Integer.parseInt(userInput);
            }
            System.out.println("Please enter a VALID integer number:");
        }
    }

    private static String getSortedEstimations(String str) {
        String[] strEstimations = str.split(" ");
        int[] estimations = new int[strEstimations.length];

        for(int i = 0; i < strEstimations.length; i++)
            estimations[i] = Integer. parseInt(strEstimations[i]);

        StringBuilder stringBuilder = new StringBuilder();
        estimations = sort(estimations);
        for(int i = 0; i < estimations.length; i++) {
            stringBuilder.append(estimations[i] + ", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());

        return stringBuilder.toString();
    }

    private static int[] sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for(int j = 0; j < len - i - 1; j++) {
                if(arr[j + 1] > arr[j]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
        return arr;
    }

    private static boolean isPositiveInteger(String str) {
        str = str.trim();
        if(str.isEmpty())   return false;

        for(int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i)))   return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        String[][] data = {
            {"1600", "1953", "163", "8"},
            {
                "When was the first opera performed?",
                "Which year did Stalin die?",
                "How many stores is the tallest building in the world?",
                "How many world champions(as a nation) are in football?"
            }
        };

        StringBuilder stringBuilder = new StringBuilder();
        String name = getUserName();
        String question;
        int answer;
        int guess;
        int index = rand.nextInt(data[0].length + 1);


        System.out.println("Let the game begin!");

        answer = Integer.parseInt(data[0][index]);
        question = data[1][index];
        System.out.println(question);

        System.out.println("Please enter your estimation:");
        while(true) {
            guess = getValidIntNumber();

            if(guess < answer) {
                System.out.println("Your number is too small. Please, try again.");
                stringBuilder.append(String.format("%d ", guess));
            } else if(guess > answer) {
                System.out.println("Your number is too big. Please, try again.");
                stringBuilder.append(String.format("%d ", guess));
            } else {
                System.out.printf("Congratulations, %s!\n", name);
                String strEstimations = stringBuilder.toString();
                if(!strEstimations.isEmpty())
                    System.out.printf("Your numbers: %s", getSortedEstimations(strEstimations));
                break;
            }
        }

    }
}

