package game.Player;

import game.Board.Board;
import game.Ship.Ship;
import game.Ship.ShipFormula;

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
        ShipFormula shipFormula = new ShipFormula();
        // check and place if is possible to place ship on board
        if (this.board.isPlacementValid(shipFormula)) {
            this.board.placeShip(shipFormula);
            return true;
        }else{
            return false;
        }
    }


}
