package game.Battleship;

import game.Board.Board;
import game.Player.Player;
import game.Player.ComputerPlayer;
import game.Ship.Ship;
import game.Battleship.FightPhase;

public class Game extends Battleship {
    boolean continueGame;
    Player player1;
    Player player2;
    FightPhase fightPhase;

    public Game() {
        switch(super.gameMode){
            case 1: // player vs player;
                this.player1 = new Player();
                this.player2 = new Player();
                break;
            case 2: // player vs ai;
                this.player1 = new Player();
                this.player2 = new ComputerPlayer();
                break;
            case 3: // ai vs ai;
                this.player1 = new ComputerPlayer();
                this.player2 = new ComputerPlayer();
                break;
        }

    }


    public void run() {
        /*
        - first phase: ship placement
        - second phase: real game
        ------------------------------------
         */
        System.out.println("placement phase");
        System.out.println("fighting phase");
    }

    public void CheckPlayerMove() {
        /*
        -check player move
         */

    }

    //condition to endgame status switch
    private void updateGameStatus(){
    }



}
