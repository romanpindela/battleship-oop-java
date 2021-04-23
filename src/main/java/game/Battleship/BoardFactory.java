package game.Battleship;

import game.Player.ComputerPlayer;
import game.Player.Player;
import game.Settings.Settings;

public class BoardFactory extends Game {
    int numbersOfShipsToPlace;

    public BoardFactory() {
        this.numbersOfShipsToPlace = Settings.globalNumberOfShips;
    }


    public void askPlayersForShips(Player p1, Player p2, int gameMode){
        switch(gameMode){
            case 1: // player vs player
                break;
            case 2: // player vs ai
                break;
            case 3: // ai vs ai
                randomPlacement(p1);
                randomPlacement(p2);
                break;
        }
    }

    public void randomPlacement(Player player){
        // ask for ship computer
        int numberOfPlacedShips = 0;
        while(numberOfPlacedShips != this.numbersOfShipsToPlace){
            if (player.placeNewShip()){
                numberOfPlacedShips++;
            }
        }



    }

    public void manualPlacement(Player player){
        // ask for ship user

    }

}
