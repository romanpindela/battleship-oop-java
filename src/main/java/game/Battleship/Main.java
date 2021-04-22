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

        ShipFormula shipFormula2 = player.askForShipFormula2();
        ShipFormula shipFormula3 = player.askForShipFormula3();

        Ship newShip2 = new Ship(shipFormula2);
        player.shipList.add(newShip2);
        player.board.addShip(newShip2);

        Ship newShip3 = new Ship(shipFormula3);
        player.shipList.add(newShip3);
        player.board.addShip(newShip3);


        player.placeShip();
        displayBoard.displayBoard(player.board);


    }
}
