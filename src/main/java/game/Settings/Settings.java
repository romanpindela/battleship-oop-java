package game.Settings;

import java.util.Locale;

import game.Board.Square;
import game.Board.SquareStatus;

public class Settings {
    public static int globalBoardSize = 10;
    public static String rowNames = "abcdefghijklmnopqrstuvwxyz".toUpperCase(Locale.ROOT);
    public static SquareStatus.squareStatus defaultSquareStatus = SquareStatus.squareStatus.EMPTY;
    public static int globalNumberOfShips = 5;
}
