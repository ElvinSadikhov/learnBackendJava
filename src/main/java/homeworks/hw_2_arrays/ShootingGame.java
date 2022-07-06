package homeworks.hw_2_arrays;

import java.util.Random;
import java.util.Scanner;

public class ShootingGame {
    private static final int playgroundSize = 5;
    private static final int targetLength = 3;

    private static final boolean[][] playground = new boolean[playgroundSize][playgroundSize];
    private static final int[][] targetCoordinates = new int[targetLength][2];

    private static void drawPlayground() {
        System.out.println();

        for(int i = 0; i <= playgroundSize; i++) {
            System.out.print(i + " | ");
        }

        System.out.println();

        for(int i = 1; i <= playgroundSize; i++) {
            System.out.print(i + " | ");
            for(int j = 1; j <= playgroundSize; j++) {
                System.out.print(isCellFree(i, j) ? "-" : isTarget(i, j) ? "x" : "*");
                System.out.print(" | ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private static void setTarget() {
        Random rand = new Random();
        boolean isTargetHorizontal = rand.nextBoolean();
        int  targetStartingPosition = rand.nextInt(playgroundSize - (targetLength - 1) - 1) + 1;
        int targetSecondCoordinatePosition = rand.nextInt(playgroundSize);

        for(int i = 0; i < targetLength; i++) {
            if(isTargetHorizontal) {
                targetCoordinates[i][0] = targetSecondCoordinatePosition;
                targetCoordinates[i][1] = targetStartingPosition + i;
            } else {
                targetCoordinates[i][0] = targetStartingPosition + i;
                targetCoordinates[i][1] = targetSecondCoordinatePosition;
            }
        }
    }

    private static int[] getCoordinatesFromUser() {
        Scanner in = new Scanner(System.in);
        int[] coordinates = new int[2];
        String userInput;

        System.out.println("Please enter a line for fire:");
        userInput = in.nextLine();
        while(!isValidValue(userInput)) {
            System.out.printf("Please enter a number in range (%d, %d):\n", 1, playgroundSize);
            userInput = in.nextLine().trim();
        }
        coordinates[0] = Integer.parseInt(userInput);

        System.out.println("Please enter a bar for fire:");
        userInput = in.nextLine();
        while(!isValidValue(userInput)) {
            System.out.printf("Please enter a number in range (%d, %d):\n", 1, playgroundSize);
            userInput = in.nextLine().trim();
        }
        coordinates[1] = Integer.parseInt(userInput);


        return coordinates;
    }

    private static int[] getFreeCellCoordinates() {
        int coordinates[] = getCoordinatesFromUser();
        System.out.println(coordinates[0] + " " + coordinates[1]);
        while(!isCellFree(coordinates[0], coordinates[1])) {
            System.out.printf("The cell with coordinates (%d, %d) is already shot! Please enter a free cell!\n", coordinates[0], coordinates[1]);
            coordinates = getCoordinatesFromUser();
        }

        return coordinates;
    }

    private static void shoot(int firstCoordinate, int secondCoordinate) {
        playground[firstCoordinate - 1][secondCoordinate - 1] = true;
    }

    private static boolean isCellFree(int firstCoordinate, int secondCoordinate) {
        return !playground[firstCoordinate - 1][secondCoordinate - 1];
    }

    private static boolean isTarget(int firstCoordinate, int secondCoordinate) {
        for(int[] cell: targetCoordinates) {
            if(cell[0] == firstCoordinate && cell[1] ==secondCoordinate)
                return true;
        }
        return false;
    }

    private static boolean isTargetDefeated() {
        for(int[] cell: targetCoordinates) {
            if(isCellFree(cell[0], cell[1]))
                return false;
        }
        return true;
    }

    private static boolean isValidValue(String str) {
        if(!isPositiveInteger(str)) return false;

        int intValue = Integer.parseInt(str = str.trim());

        return intValue >= 1 && intValue <= playgroundSize;
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
        int[] coordinates;

        setTarget();

        System.out.println("All set. Get ready to rumble!");

        drawPlayground();
        while(!isTargetDefeated()) {
            coordinates = getFreeCellCoordinates();
            shoot(coordinates[0], coordinates[1]);
            drawPlayground();
        }

        System.out.println("You have won!");

    }

}
