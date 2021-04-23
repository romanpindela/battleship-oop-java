package game.Battleship;

import game.Board.Board;
import game.Display.DisplayBoard;
import game.Player.Player;
import game.Player.ComputerPlayer;
import game.Ship.Ship;
import game.Battleship.FightPhase;
import game.Utils.Utils;

public class Game extends Battleship {
    boolean continueGame;
    Player player1;
    Player player2;

    protected DisplayBoard displayBoard;

    BoardFactory boardFactory;
    FightPhase fightPhase;
    int gameMode;

    public Game(){
        displayBoard = new DisplayBoard();
    }

    public Game(int gameMode) {
        displayBoard = new DisplayBoard();
        this.gameMode = gameMode;

        switch (this.gameMode) {
// player vs player;
            case 1 -> {
                this.player1 = new Player();
                this.player2 = new Player();
            }
// player vs ai;
            case 2 -> {
                this.player1 = new Player();
                this.player2 = new ComputerPlayer();
            }
// ai vs ai;
            case 3 -> {
                this.player1 = new ComputerPlayer();
                this.player2 = new ComputerPlayer();
            }
            default -> throw new IllegalStateException("Unexpected value: " + this.gameMode);
        };

    }


    public void run() {
        boardFactorPhase();
        fightPhase();

    }

    public void boardFactorPhase(){
        this.boardFactory = new BoardFactory();
        // first phase: ship placement
        this.boardFactory.askPlayersForShips(this.player1, this.player2, this.gameMode);
        //displaying both players' boards
        displayBoard.displayBoard(player1.board);
        displayBoard.displayBoard(player2.board);
        Utils.pressAnyKeyToContinue();
    }

    public void fightPhase(){
        this.fightPhase = new FightPhase();
        // second phase: real game
        this.fightPhase.fight();
        Utils.pressAnyKeyToContinue();
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
