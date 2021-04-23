package game.Player;

import game.Input.Input;
import game.Settings.Settings;
import game.Ship.ShipFormula;
import game.Ship.ShipType;

import java.util.ArrayList;
import java.util.Random;


public class ComputerPlayer extends Player{

    public ComputerPlayer() {
        this.name = "Computer";
    }

    public static void shot(){
    /*
    random shots
    fields around ships are excluded
    following the direction if getting hit
     */
    }

    @Override
    public boolean placeNewShip() {
        ShipFormula shipFormula = Input.askForShipFormulaComputer();
        return super.placeShip(shipFormula);
    }
}
