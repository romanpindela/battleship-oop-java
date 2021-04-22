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

        Ship testedShip = new Ship(shipFormula);
        boolean onBoardCondition = false;
        boolean emptySquaresCondition = false;
        boolean notNearAnotherShipCondition = false;
/*
         conditions for accepting placement of a ship build from shipFormula
*/
        // onBoard condition: ships' square are on board, ship fits on board
        onBoardCondition = onBoardCheck(testedShip);

        // emptySquares condition: squares for placing ship are empty
        emptySquaresCondition = emptySquaresCheck(testedShip);
        
        // notNearAnotherShip condition: square around ship's square are also empty
        notNearAnotherShipCondition = notNearAnotherShipCheck(testedShip);
        
        return onBoardCondition && emptySquaresCondition && notNearAnotherShipCondition;

    }

    private boolean onBoardCheck(Ship testedShip) {
        int xMin = 0;
        int yMin = 0;
        int xMax = Settings.globalBoardSize - 1;
        int yMax = Settings.globalBoardSize - 1;

        int firstSquareIndex = 0;
        int lastSquareIndex = testedShip.size() - 1;

        boolean firstSquareOnBoard = xMin < testedShip.squares.get(firstSquareIndex).getX() &&
                testedShip.squares.get(firstSquareIndex).getX() < xMax &&
                yMin < testedShip.squares.get(firstSquareIndex).getY() &&
                testedShip.squares.get(firstSquareIndex).getY() < yMax;

        boolean lastSquareOnBoard = xMin < testedShip.squares.get(lastSquareIndex).getX() &&
                testedShip.squares.get(lastSquareIndex).getX() < xMax &&
                yMin < testedShip.squares.get(lastSquareIndex).getY() &&
                testedShip.squares.get(lastSquareIndex).getY() < yMax;

        return ( firstSquareOnBoard && lastSquareOnBoard);
    }


    private boolean emptySquaresCheck(Ship testedShip) {
        int firstSquareIndex = 0;
        int lastSquareIndex = testedShip.size() - 1;
        boolean emptySquaresCheck = true;
        for (int squareIndex = 0; squareIndex <= lastSquareIndex; squareIndex++) {
            int squareX = testedShip.squares.get(squareIndex).getX();
            int squareY = testedShip.squares.get(squareIndex).getY();
            if (this.board.get(squareX).get(squareY).status != SquareStatus.squareStatus.EMPTY){
                emptySquaresCheck = false;
                break;
            }
        }
        return emptySquaresCheck;
    }

    private boolean notNearAnotherShipCheck(Ship testedShip) {
        int xMin = 0;
        int yMin = 0;
        int xMax = Settings.globalBoardSize - 1;
        int yMax = Settings.globalBoardSize - 1;

        int firstSquareIndex = 0;
        int lastSquareIndex = testedShip.size() - 1;

        boolean notNearAnotherShipCheck = true;

/*        testedShip.squares.forEach(square -> squareCheck(square));

        testedShip.squares.stream().fi*/

        for (int squareIndex = 0; squareIndex <= lastSquareIndex; squareIndex++) {
        // check for every square: checking if there are empty spaces around
        // or there is no such space (ship near the edge)


        // additional checking the corner of the beginning and end of the ship
        }

        return notNearAnotherShipCheck;
    }

    private boolean squareCheck(Square square) {
        return false;
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
