package game.Ship;

import game.Board.Square;

import java.util.ArrayList;
import java.util.Arrays;

import game.Board.SquareStatus;
import game.Ship.ShipType;
import game.Ship.PlacingDirection;

public class Ship {
    public ArrayList<Square> squares;
    public ShipType.shipOrientation shipOrientation;

    public Ship(ShipFormula shipFormula){
        this.squares = new ArrayList<Square>();

        int startPointX = shipFormula.startCoord00[0];
        int startPointY = shipFormula.startCoord00[1];
        int shipTypeSize = ShipType.getSize(shipFormula.shipType);
        this.shipOrientation = shipFormula.shipOrientation;

        int placingDirectionFactor = PlacingDirection.getPlacingDirectionFactor(shipFormula.placingDirection);
        SquareStatus.squareStatus shipSquareStatus = SquareStatus.squareStatus.SHIP;

        // building ship from squares
        for (int newSquareIndex = 0; newSquareIndex < shipTypeSize; newSquareIndex++) {

            int newSquareX;
            int newSquareY;
            if (shipOrientation == ShipType.shipOrientation.Horizontal){
                newSquareX = startPointX + placingDirectionFactor * newSquareIndex;
                newSquareY = startPointY;
            } else { // vertical
                newSquareX = startPointX;
                newSquareY = startPointY + placingDirectionFactor * newSquareIndex;
            }


            Square newSquare = new Square(newSquareX, newSquareY, shipSquareStatus);
            this.squares.add(newSquare);
        }
    }

    //check for ship in squares
    public boolean isItAShip(int[] SHIP){
        return Arrays.asList(this.squares).contains(SHIP);
    }


    public int size(){
        return squares.size();
    }


}
