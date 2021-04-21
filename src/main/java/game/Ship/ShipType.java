package game.Ship;

import game.Board.SquareStatus;

import java.util.EnumMap;

public class ShipType{

    public enum shipType{
        Carrier, Cruiser, Battleship, Submarine, Destroyer;
    }

    public enum shipOrientation{
        Vertical, Horizontal
    }

    public static int getSize(shipType size){
        int health = switch (size) {
            case Destroyer -> 2;
            case Submarine, Cruiser -> 3;
            case Battleship -> 4;
            case Carrier -> 5;
        };
        return health;
    }
}
