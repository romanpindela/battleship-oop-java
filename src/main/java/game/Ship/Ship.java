package game.Ship;

import game.Board.Square;

import java.util.ArrayList;

import game.Board.SquareStatus;
import game.Ship.ShipType;
import game.Ship.PlacingDirection;

public class Ship {

    ArrayList<Square> squares;


    public Ship(int[] startCoord00,
                ShipType.shipType shipType,
                ShipType.shipOrientation shipOrientation,
                PlacingDirection.placingDirection placingDirection
                ){

//            if (shipOrientation == ShipType.shipOrientation.Vertical){
//                buildShipVertically(startCoord00, shipType);
//            }else{ // Horizontal orientation
//                buildShipHorizontally(startCoord00,shipType);
//            }
    }

    private void buildShipHorizontally(int[] startCoord00, ShipType.shipType shipType) {

        for (int squareIndex = 0
                ; squareIndex < ShipType.getSize(shipType)
                ; squareIndex++) {

            //

            int newSquareXCoord = startCoord00[0] + squareIndex;
            int newSquareYCoord = startCoord00[1];
            this.squares.add(new Square(newSquareXCoord, newSquareYCoord));
        }
    }

    private void buildShipVertically(int[] startCoord00, ShipType.shipType shipType) {

    }


}
