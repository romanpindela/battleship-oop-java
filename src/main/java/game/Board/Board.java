package game.Board;

import java.util.ArrayList;
import game.Settings.Settings;
import game.Ship.PlacingDirection;
import game.Ship.Ship;
import game.Ship.ShipFormula;
import game.Ship.ShipType;

public class Board {

    ArrayList<ArrayList<Square>> board;

    public int getSize() {
        return size;
    }

    int size;

    public Board() {
        this.size = Settings.globalBoardSize;
        char[] rowNames = Settings.rowNames.substring(0,size).toCharArray();
        SquareStatus.squareStatus defaultStatus = Settings.defaultSquareStatus;
        this.board = new ArrayList<ArrayList<Square>>();

        for (int rowSquareIndex = 0; rowSquareIndex < size; rowSquareIndex++) {
            for (int columnSquareIndex = 0; columnSquareIndex < size; columnSquareIndex++) {
                this.board.add(new ArrayList<Square>());
                this.board.get(rowSquareIndex)
                        .add(new Square(rowNames[rowSquareIndex], columnSquareIndex, defaultStatus));
            }
        }
    }

    public ArrayList<ArrayList<Square>> getBoard() {
        return board;
    }

    public boolean isPlacementValid(ShipFormula shipFormula){

        // conditions for the correct placing of the ship
        // 1'st condition


        return true;
    }


    public void addShip(Ship ship) {
        int shipTypeSize = ship.size();
        SquareStatus.squareStatus shipStatus = SquareStatus.squareStatus.SHIP;

        for (int shipSquareIndex = 0; shipSquareIndex < shipTypeSize; shipSquareIndex++) {
            int shipSquareX = ship.squares.get(shipSquareIndex).getX();
            int shipSquareY = ship.squares.get(shipSquareIndex).getY();

            this.board.get(shipSquareX).get(shipSquareY).setStatus(shipStatus);
        }

    }
}
