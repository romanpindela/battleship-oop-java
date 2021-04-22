package game.Player;

import game.Board.Board;
import game.Ship.PlacingDirection;
import game.Ship.Ship;
import game.Ship.ShipFormula;
import game.Ship.ShipType;

import java.util.ArrayList;

public class Player {
    public String name;
    public Board board;
    public Board oponentHitBoard;

    public static void isAlive() {
    }
    public static void shot(){
    }

    ArrayList<Ship> shipList;

    public ArrayList<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(ArrayList<Ship> shipList) {
        this.shipList = shipList;
    }

    public boolean placeShip(){
        // ask for shipFormula
        ShipFormula shipFormula = new ShipFormula(new int[]{0,0},
                                    ShipType.shipType.Carrier,
                                    ShipType.shipOrientation.Horizontal,
                                    PlacingDirection.placingDirection.Right);

        // check and place if is possible to place ship on board
        if (this.board.isPlacementValid(shipFormula)) {
            // create new ship and add it to shipList
            Ship newShip = new Ship(shipFormula);
            // place new ship in player board
            this.board.placeShip(newShip);
            return true;
        }else{
            return false;
        }
    }


}
