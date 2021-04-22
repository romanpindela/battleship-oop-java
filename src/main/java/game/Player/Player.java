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

    public ArrayList<Ship> shipList;

    public Player(){
        this.board = new Board();
        this.oponentHitBoard = new Board();
        this.shipList = new ArrayList<Ship>();
    }


    public boolean placeShip(){
        // ask for shipFormula
        ShipFormula shipFormula = askForShipFormula();

        // check and place if is possible to place ship on board
        boolean possibilityOfPlacingShip = this.board.isPlacementValid(shipFormula);
        if (!possibilityOfPlacingShip){
            shipFormula.revertPlacingDirection(); // check possibility of placing ship in opposite direction
            possibilityOfPlacingShip = this.board.isPlacementValid(shipFormula);
        }

        if (possibilityOfPlacingShip) {
            // create new ship and add it to shipList
            Ship newShip = new Ship(shipFormula);
            this.shipList.add(newShip);
            // place new ship in player board
            this.board.addShip(newShip);
            return true;
        }else{
            return false;
        }
    }

    public ShipFormula askForShipFormula(){

        /*
            miejsce dla Bartka - do określenie ShipFormula z inputów użytkownika

            narazie jest na sztywno

         */

        return new ShipFormula(new int[]{5,0},
                ShipType.shipType.Carrier,
                ShipType.shipOrientation.Vertical);
    }


    public ShipFormula askForShipFormula2(){

        /*
            miejsce dla Bartka - do określenie ShipFormula z inputów użytkownika

            narazie jest na sztywno

         */

        return new ShipFormula(new int[]{5,0},
                ShipType.shipType.Carrier,
                ShipType.shipOrientation.Horizontal);
    }

    public ShipFormula askForShipFormula3(){

        /*
            miejsce dla Bartka - do określenie ShipFormula z inputów użytkownika

            narazie jest na sztywno

         */

        return new ShipFormula(new int[]{3,3},
                ShipType.shipType.Carrier,
                ShipType.shipOrientation.Horizontal);
    }

    public static void isAlive() {
    }
    public static void shot(){
    }


}
