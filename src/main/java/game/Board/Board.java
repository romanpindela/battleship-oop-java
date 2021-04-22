package game.Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import game.Settings.Settings;
import game.Ship.Ship;
import game.Ship.ShipFormula;

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
        boolean onBoardCondition = true;
        boolean emptySquaresCondition = true;
        boolean notNearAnotherShipCondition = true;
/*
         conditions for accepting placement of a ship build from shipFormula
*/
        // onBoard condition: ships' square are on board, ship fits on board
        onBoardCondition = onBoardCheck(testedShip);
        if (!onBoardCondition){return false;};
        // emptySquares condition: squares for placing ship are empty
        emptySquaresCondition = emptySquaresCheck(testedShip);
        if (!emptySquaresCondition){return false;};

        // notNearAnotherShip condition: square around ship's square are also empty
        notNearAnotherShipCondition = notNearAnotherShipCheck(testedShip);
        if (!notNearAnotherShipCondition){return false;}
        else { return true;}
    }

    private boolean onBoardCheck(Ship testedShip) {
        int xMin = 0;
        int yMin = 0;
        int xMax = Settings.globalBoardSize - 1;
        int yMax = Settings.globalBoardSize - 1;

        int firstSquareIndex = 0;
        int lastSquareIndex = testedShip.size() - 1;

        boolean firstSquareOnBoard = xMin <= testedShip.squares.get(firstSquareIndex).getX() &&
                testedShip.squares.get(firstSquareIndex).getX() <= xMax &&
                yMin <= testedShip.squares.get(firstSquareIndex).getY() &&
                testedShip.squares.get(firstSquareIndex).getY() <= yMax;

        boolean lastSquareOnBoard = xMin <= testedShip.squares.get(lastSquareIndex).getX() &&
                testedShip.squares.get(lastSquareIndex).getX() <= xMax &&
                yMin <= testedShip.squares.get(lastSquareIndex).getY() &&
                testedShip.squares.get(lastSquareIndex).getY() <= yMax;

        return ( firstSquareOnBoard && lastSquareOnBoard);
    }


    private boolean emptySquaresCheck(Ship testedShip) {
        int xMin = 0;
        int yMin = 0;
        int xMax = Settings.globalBoardSize - 1;
        int yMax = Settings.globalBoardSize - 1;

        int firstSquareIndex = 0;
        int lastSquareIndex = testedShip.size() - 1;
        boolean emptySquaresCheck = true;
        for (int squareIndex = 0; squareIndex <= lastSquareIndex; squareIndex++) {
            int squareX = testedShip.squares.get(squareIndex).getX();
            int squareY = testedShip.squares.get(squareIndex).getY();

            if (squareX >= xMin && squareX <= xMax &&
                squareY >= yMin && squareX <= yMax){ // square (squareX, squareY) is on board
                if (this.board.get(squareX).get(squareY).status != SquareStatus.squareStatus.EMPTY){
                    emptySquaresCheck = false;
                    break;
                }
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

        int squaresCountWithNotNearAnotherShip = (int) testedShip.squares.stream()
                .filter(square -> squareCheckFreeSpaceAround(square, testedShip))
                .count();

        if (squaresCountWithNotNearAnotherShip == testedShip.squares.size()){
            return notNearAnotherShipCheck = true;
        }else{
            return notNearAnotherShipCheck = false;
        }
    }

    private boolean squareCheckFreeSpaceAround(Square s, Ship testedShip) {
        boolean squaresAroundAreEmpty;
        ArrayList<Square> squares = new ArrayList<Square>();

        if (s.y-1 >= 0){
            Square squareUp = this.board.get(s.x).get(s.y-1);
            if (!testedShip.squares.contains(squareUp)){
            squares.add(squareUp);}
        }
        if (s.y+1 < this.size){
            Square squareDown = this.board.get(s.x).get(s.y+1);
            if (!testedShip.squares.contains(squareDown)){
            squares.add(squareDown);}
        }
        if (s.x-1 >= 0){
            Square squareLeft = this.board.get(s.x-1).get(s.y);
            if (!testedShip.squares.contains(squareLeft)){
            squares.add(squareLeft);}
        }
        if (s.x+1 < this.size){
            Square squareRight = this.board.get(s.x+1).get(s.y);
            if (!testedShip.squares.contains(squareRight)){
            squares.add(squareRight);}
        }

        SquareStatus.squareStatus emptySign = SquareStatus.squareStatus.EMPTY;

        Optional<Square> notEmptySquare = squares.stream()
                .filter(square -> square.status != emptySign)
                .findAny();

        if (notEmptySquare.isPresent()){
            return squaresAroundAreEmpty = false;
        }else{
            return squaresAroundAreEmpty = true;
        }
    }



    public void addShip(Ship ship) {
        int shipTypeSize = ship.size();
        SquareStatus.squareStatus shipStatus = SquareStatus.squareStatus.SHIP;

        for (int shipSquareIndex = 0; shipSquareIndex < shipTypeSize; shipSquareIndex++) {
            int shipSquareX = ship.squares.get(shipSquareIndex).getX();
            int shipSquareY = ship.squares.get(shipSquareIndex).getY();

            this.board.get(shipSquareX).get(shipSquareY).setStatus(shipStatus);
        }
        int x;
    }
}
