package game.Input;

import game.Settings.Settings;

public class Input {
    public static void isMoveOnBoard(){
    }

    public static void isFieldAlreadyTaken(){
    }

    public static int[] changeCoordsFormat(String A1Coords){
        A1Coords = A1Coords.toUpperCase();
        int firstCoord = Settings.rowNames.toUpperCase().indexOf(A1Coords.toCharArray()[0]);
        int secondCoord = Character.getNumericValue(A1Coords.toCharArray()[1]) - 1;
        return new int[]{firstCoord, secondCoord};
    }




}
