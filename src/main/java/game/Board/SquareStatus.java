package game.Board;

import java.util.EnumMap;

public class SquareStatus{

    public enum squareStatus{
        HIT, MISS, EMPTY, DESTROYED, SHIP;
    }

    public static char getCharacter(squareStatus status){
        char result = switch (status) {
            case HIT -> 'H';
            case MISS -> 'M';
            case EMPTY -> '~';
            case DESTROYED -> 'D';
            case SHIP -> 'S';
        };
        return result;
    }
}
