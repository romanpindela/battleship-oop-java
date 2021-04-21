package game.Battleship;

import game.Board.Board;
import game.Display.Display;
import game.Display.DisplayBoard;
import game.Input.Input;

public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        //display.gameMenu();

        Board board = new Board();
        DisplayBoard displayBoard = new DisplayBoard();
        displayBoard.displayBoard(board);

        int[] newCoords = Input.changeCoordsFormat("A1");
        System.out.println(newCoords[0] + "" + newCoords[1]);
    }
}
