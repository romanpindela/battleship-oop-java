package game.Battleship;

import game.Board.Board;
import game.Display.Display;
import game.Display.DisplayBoard;
import game.Input.Input;
import game.Player.Player;
import game.Ship.Ship;
import game.Ship.ShipFormula;

public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        //display.gameMenu();



 // tests

        DisplayBoard displayBoard = new DisplayBoard();
/*      Board board = new Board();
        displayBoard.displayBoard(board);

        int[] newCoords = Input.changeCoordsFormat("A1");
        System.out.println(newCoords[0] + "" + newCoords[1]);
        */
        Player player = new Player();

        player.placeShip();
        displayBoard.displayBoard(player.board);


    }
}
