package game.Player;

import game.Battleship.FightPhase;
import game.Board.Board;
import game.Board.Square;
import game.Board.SquareStatus;
import game.Input.Input;
import game.Ship.PlacingDirection;
import game.Ship.Ship;
import game.Ship.ShipFormula;
import game.Ship.ShipType;

import javax.lang.model.type.NullType;
import java.util.ArrayList;

import static game.Input.Input.*;

public class Player extends FightPhase {
    public String name;
    public Board board;
    public Board oponentHitBoard;
    Ship[] fleet;
    boolean destroyed;

    public ArrayList<Ship> shipList;

    public Player(){
        this.name = "Human";
        this.board = new Board();
        this.oponentHitBoard = new Board();
        this.shipList = new ArrayList<Ship>();
    }


    public boolean placeNewShip(){
        ShipFormula shipFormula = Input.askForShipFormulaManual();
        return placeShip(shipFormula);
    }

     boolean placeShip(ShipFormula shipFormula){
        // ask for shipFormula

        // check and place if is possible to place ship on board
        boolean possibilityOfPlacingShip = this.board.isPlacementValid(shipFormula);
        if (!possibilityOfPlacingShip){
            shipFormula.revertPlacingDirection(); // check possibility of placing ship in opposite direction
            possibilityOfPlacingShip = this.board.isPlacementValid(shipFormula);
        }

        boolean placingSuccess;
        if (possibilityOfPlacingShip) {
            // create new ship and add it to shipList
            Ship newShip = new Ship(shipFormula);
            this.shipList.add(newShip);
            // place new ship in player board
            this.board.addShip(newShip);
            placingSuccess = true;
        }else{
            placingSuccess = false;
        }
        return placingSuccess;
    }


    public static void isAlive() {
    }


    public boolean shootingLocation(Player opponent){
        int[] shoot = changeCoordsFormat(getPlayerInputCoordinates());
        for (Ship s: fleet){
            if (s.isItAShip(shoot)){
                return true;
            }
        }
     return false;
    }

    public void checkStatus(){
        this.destroyed = true;
        //maybe some kind of for loop to check SHIPS status as a count?
        /*for (int i = 0; i < rozmiarFloty; i++){ //flota zawsze od 17
            if (!flota[i].HIT()){
                this.destroyed = false;
            }
        }*/
    }
}
