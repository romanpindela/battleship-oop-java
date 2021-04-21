package game.Player;

import game.Board.Board;
import game.Ship.Ship;
import java.util.List;
import java.util.ArrayList;

public class Player {
    public String name;
    public Board board;

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


    public boolean placeShip(Ship ship){
        if (this.board.isPlacementValid(ship)) {
            this.board.placeShip(ship);
            return true;
        }else{
            return false;
        }
    }


}
