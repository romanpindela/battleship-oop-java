package game.Display;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Display {
    String test;
    Scanner sc = new Scanner(System.in);
    boolean menuOn = true;


    //declaring the colors for terminal output
    public static final String ANSI_RESET = "\u001B[0m"; //used to revert to the original color of terminal font
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public void gameMenu() {
        int choice;

        //printing simple menu in console TODO: colors, ASCII graphics, error handling
        System.out.println(ANSI_CYAN + "\n" +
                "                                     # #  ( )\n" +
                "                                  ___#_#___|__\n" +
                "                              ___|____________|___\n" +
                "                      --=====| | |            | | |====--\n" +
                "                 =====| |.---------------------------. | |====\n" +
                "    \\--------------------'   .  .  .  .  .  .  .  .   '--------------/\n" +
                "     \\                                                             /\n" +
                "      \\___________________________________________________________/" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "\n" +
                "  __  __      _        __  __              \n" +
                " |  \\/  |__ _(_)_ _   |  \\/  |___ _ _ _  _ \n" +
                " | |\\/| / _` | | ' \\  | |\\/| / -_) ' \\ || |\n" +
                " |_|  |_\\__,_|_|_||_| |_|  |_\\___|_||_\\_,_|\n" +
                "                                           \n" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "1. Player vs Player");
        System.out.println("2. Player vs AI");
        System.out.println("3. AI vs AI");
        System.out.println("4. Highscores" + ANSI_RESET);
        System.out.println(ANSI_RED + "5. Exit" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Enter your choice(1-5)" + ANSI_RESET);


        while (menuOn) {
            try {
                choice = sc.nextInt();

                //base work of menu using switch command
                switch (choice) {
                    case 1 -> changeMenu();
                    case 2 -> changeMenu();
                    case 3 -> test = "test3";
                    case 4 -> test = "test4";
                    case 5 -> System.exit(0);
                    default -> System.out.println(ANSI_RED + "Provide a number from 1 to 5!" + ANSI_RESET);
                }
                System.out.println(test);
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Provide a number from 1 to 5!" + ANSI_RESET);
                sc.nextLine();
            }
        }
    }

    //testing shutting down menu
    public void changeMenu(){
        this.menuOn = false;
        this.test = "chyba działa";
    }

    public void printBoard() {
    }

    public void printGamePlay() {
    }

    public void printOutcomeOfFinishedGame() {
    }

    //method to clear the screen of terminal to simulate refreshing of the screen after an action
    public static void screenClear() {
        System.out.print("\\033[H\\033[2J");
        System.out.flush();
    }
}

