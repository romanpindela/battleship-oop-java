package game.Battleship;

import game.Board.Board;
import game.Display.Display;
import game.Display.DisplayBoard;
import game.Input.Input;
import game.Player.ComputerPlayer;
import game.Player.Player;
import game.Ship.Ship;
import game.Ship.ShipFormula;

public class Main {
    public static void main(String[] args) {
//        ComputerPlayer computerPlayer = new ComputerPlayer();
//        Player player = new Player();
//        DisplayBoard dB = new DisplayBoard();
//        BoardFactory boardFactory = new BoardFactory();
//        boardFactory.randomPlacement(computerPlayer);
//        boardFactory.randomPlacement(player);
//        dB.displayBoard((computerPlayer.board));
//

        Battleship battleship = new Battleship();
        battleship.run();


 // tests

        DisplayBoard displayBoard = new DisplayBoard();
/*      Board board = new Board();
        displayBoard.displayBoard(board);

        int[] newCoords = Input.changeCoordsFormat("A1");
        System.out.println(newCoords[0] + "" + newCoords[1]);
        */

/*        ComputerPlayer player = new ComputerPlayer();

        player.placeNewShip();
        player.placeNewShip();
        player.placeNewShip();
        player.placeNewShip();
        player.placeNewShip();
        displayBoard.displayBoard(player.board);*/


    }
}
