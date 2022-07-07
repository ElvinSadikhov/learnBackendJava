package homeworks.hw_3_strings;

import java.util.Scanner;


public class WeekPlanner {

    private static final String[][] schedule = new String[7][2];

    private static void welcoming() {
        System.out.println("Welcome to Week Planner!\n");
    }

    private static void askForInput() {
        System.out.println("Please, input the day of the week:");
    }

    private static void displayErrorMessage() {
        System.out.println("Sorry, I don't understand you, please try again.");
    }

    private static void closeApp() {
        System.out.println("Closing application...");
    }

    private static void prepareSchedule() {
        schedule[0][0] = "Sunday";
        schedule[1][0] = "Monday";
        schedule[2][0] = "Tuesday";
        schedule[3][0] = "Wednesday";
        schedule[4][0] = "Thursday";
        schedule[5][0] = "Friday";
        schedule[6][0] = "Saturday";
    }

    private static void displayInfo(String weekDay) {
        for(int i = 0; i < schedule.length; i++) {
            if(weekDay.equalsIgnoreCase(schedule[i][0])) {
                final String formattedWeekDay = weekDay.substring(0, 1).toUpperCase() + weekDay.substring(1).toLowerCase();
                if(schedule[i][1] != null) {
                    System.out.printf("Your tasks for %s: ", formattedWeekDay);
                    System.out.println(schedule[i][1] + ".\n");
                } else  System.out.printf("You have no tasks for %s!\n", formattedWeekDay);
            }
        }
    }

    private static void getNewTasks(String weekDay) {
        Scanner in = new Scanner(System.in);
        String userInput;

        for(int i = 0; i < schedule.length; i++) {
            if(weekDay.equalsIgnoreCase(schedule[i][0])) {
                System.out.printf("Please, input new tasks for %s.\n", weekDay.substring(0, 1).toUpperCase() + weekDay.substring(1).toLowerCase());
                userInput = in.nextLine().trim();

                while(userInput.isEmpty()) {
                    System.out.println("Wrong input, please try again!");
                    userInput = in.nextLine().trim();
                }

                schedule[i][1] = userInput;
                System.out.println("New tasks has been saved successfully!\n");

                break;
            }
        }
    }

    private static void run() {
        boolean isAppClosed = false;
        Scanner in = new Scanner(System.in);
        String userInput;

        askForInput();
        while(!isAppClosed) {

            userInput = in.nextLine().trim().toLowerCase();

            String words[] = userInput.split(" ");
            switch(words.length) {
                case 1:
                    switch(userInput) {
                        case "sunday":
                            displayInfo("sunday");
                            askForInput();
                            break;
                        case "monday":
                            displayInfo("monday");
                            askForInput();
                            break;
                        case "tuesday":
                            displayInfo("tuesday");
                            askForInput();
                            break;
                        case "wednesday":
                            displayInfo("wednesday");
                            askForInput();
                            break;
                        case "thursday":
                            displayInfo("thursday");
                            askForInput();
                            break;
                        case "friday":
                            displayInfo("friday");
                            askForInput();
                            break;
                        case "saturday":
                            displayInfo("saturday");
                            askForInput();
                            break;
                        case "exit":
                            isAppClosed = true;
                            closeApp();
                            break;
                        default:
                            displayErrorMessage();
                    }
                    break;
                case 2:
                    if(words[0].toLowerCase().trim().equals("change") || words[0].toLowerCase().trim().equals("reschedule")) {
                        switch(words[1].toLowerCase()) {
                            case "sunday":
                                getNewTasks("sunday");
                                askForInput();
                                break;
                            case "monday":
                                getNewTasks("monday");
                                askForInput();
                                break;
                            case "tuesday":
                                getNewTasks("tuesday");
                                askForInput();
                                break;
                            case "wednesday":
                                getNewTasks("wednesday");
                                askForInput();
                                break;
                            case "thursday":
                                getNewTasks("thursday");
                                askForInput();
                                break;
                            case "friday":
                                getNewTasks("friday");
                                askForInput();
                                break;
                            case "saturday":
                                getNewTasks("saturday");
                                askForInput();
                                break;
                            default:
                                displayErrorMessage();
                        }
                    } else  displayErrorMessage();
                    break;
                default:
                    displayErrorMessage();
            }
        }
    }

    public static void main(String[] args) {
        prepareSchedule();
        welcoming();
        run();
    }

}
