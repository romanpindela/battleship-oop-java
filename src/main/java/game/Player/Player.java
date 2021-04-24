package game.Player;

import game.Battleship.FightPhase;
import game.Battleship.Game;
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
    Game game = new Game();
    Square square = new Square();

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


    public int[] shootingLocation(Player opponent){
        ArrayList<Ship> shipListofOpponnet = opponent.shipList;
        int[] shoot = changeCoordsFormat(getPlayerInputCoordinates());
            if (shipListofOpponnet.contains(shoot)){
                return new int[]{square.getX(), square.getY()};
                //updateSquareStatus();
            } else if (!shipListofOpponnet.contains(shoot)){
                return new int[]{square.getX(), square.getY()};

            }
            return null;
    }

    public void checkStatus(){
        this.destroyed = true;
        //maybe some kind of for loop to check SHIPS status as a count?
        /*for (int i = 0; i < rozmiarFloty; i++){ //flota zawsze ma 17 pol typu Ship
            if (!flota[i].HIT()){
                this.destroyed = false;
            }
        }*/
    }
}
