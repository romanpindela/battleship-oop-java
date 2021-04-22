package game.Input;

import game.Settings.Settings;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    public static String getPlayerInputCoordinates() {
        //local variables
        Scanner input = new Scanner(System.in);
        String[] legalFirstCoord = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] legalSecondCoord = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String firstCoord;
        String secondCoord;

        //getting first input and checking if it's valid
        System.out.println("Enter first coordinate");

        while (true) {
            String x = input.next();
            boolean isOnTheList = Arrays.asList(legalFirstCoord).contains(x);
            if (isOnTheList == true) {
                firstCoord = x;
                break;
            }
            else {
                System.out.println("Must be a character out of A - J");
            }
        }

        //getting second input and checking if it's valid
        System.out.println("Enter second coordinate");
        while (true) {
            String y = input.next();
            boolean isOnTheList = Arrays.asList(legalSecondCoord).contains(y);
            if (isOnTheList ==true) {
                secondCoord = y;
                break;
            }
            else {
                System.out.println("Must be a number between 1 - 10");
            }

        }

        //combining coordinates into one returnable string used later in other functions
        String coordinates = firstCoord + secondCoord;
        return coordinates;
    }

    public static void isFieldAlreadyTaken(){
    }

    public static int[] changeCoordsFormat(String A1Coords){
        A1Coords = A1Coords.toUpperCase();
        int firstCoord = Settings.rowNames.toUpperCase().indexOf(A1Coords.toCharArray()[0]);
        int secondCoord = Character.getNumericValue(A1Coords.toCharArray()[1]) - 1;
        return new int[]{firstCoord, secondCoord};
    }

    public static String getPlayerInputShipType() {
        //local variables
        Scanner input = new Scanner(System.in);
        String[] legalShipTypes = {"Carrier", "Cruiser", "Battleship", "Submarine", "Destroyer"};
        String userShipType;

        //getting ship type and checking if the input's valid
        System.out.println("Chose ship type (Carrier, Cruiser, Battleship, Submarine, Destroyer)");
        while (true) {
            userShipType = input.next();
            boolean isOnTheList = Arrays.asList(legalShipTypes).contains(userShipType);
            if (isOnTheList == true) {
                break;
            } else {
                System.out.println("Must be one of the legal types (Carrier, Cruiser, Battleship, Submarine, Destroyer)");
            }
        }
        return userShipType;
    }

    public static String getPlayerInputShipOrientation() {
        //local variables
        Scanner input = new Scanner(System.in);
        String[] legalOrientation = {"Vertical", "Horizontal"};
        String userShipOrientation;

        //getting ship orientation and checking if the input's valid
        System.out.println("Chose ship orientation (Vertical/Horizontal)");
        while (true) {
            userShipOrientation = input.next();
            boolean isOnTheList = Arrays.asList(legalOrientation).contains(userShipOrientation);
            if (isOnTheList == true) {
                break;
            } else {
                System.out.println("Must be Vertical or Horizontal");
            }
        }
        return userShipOrientation;
    }
}
