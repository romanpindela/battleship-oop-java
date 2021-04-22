package game.Player;

import game.Board.Board;
import game.Ship.PlacingDirection;
import game.Ship.Ship;
import game.Ship.ShipFormula;
import game.Ship.ShipType;

import javax.lang.model.type.NullType;
import java.util.ArrayList;

import static game.Input.Input.*;

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

        //variables from input
        int[] inputedCoordinates = changeCoordsFormat(getPlayerInputCoordinates());
        String inputedShipType = getPlayerInputShipType();
        String inputedShipOrientation = getPlayerInputShipOrientation();


        //selecting shipType based on the provided input
        ShipType.shipType shipTypeFormula = switch(inputedShipType) {
            case "Carrier" -> ShipType.shipType.Carrier;
            case "Cruiser" -> ShipType.shipType.Cruiser;
            case "Battleship" -> ShipType.shipType.Battleship;
            case "Submarine" -> ShipType.shipType.Submarine;
            case "Destroyer" -> ShipType.shipType.Destroyer;
            default -> throw new IllegalStateException("Unexpected value: " + inputedShipType);
        };

        //selecting shipOrientation based on the provided input
        ShipType.shipOrientation shipOrientationFormula = switch(inputedShipOrientation) {
            case "Horizontal" -> ShipType.shipOrientation.Horizontal;
            case "Vertical" -> ShipType.shipOrientation.Vertical;
            default -> throw new IllegalStateException("Unexpected value: " + inputedShipOrientation);
        };

        return new ShipFormula(inputedCoordinates,
                shipTypeFormula,
                shipOrientationFormula);
    }

    public static void isAlive() {
    }
    public static void shot(){
    }


}
