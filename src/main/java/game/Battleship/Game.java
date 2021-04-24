package game.Battleship;

import game.Board.Board;
import game.Board.Square;
import game.Board.SquareStatus;
import game.Display.DisplayBoard;
import game.Player.Player;
import game.Player.ComputerPlayer;
import game.Ship.Ship;
import game.Battleship.FightPhase;
import game.Utils.Utils;

import java.util.ArrayList;

public class Game extends Battleship {
    boolean continueGame;
    boolean turn;
    public Player player1;
    public Player player2;

    protected DisplayBoard displayBoard;

    Square square = new Square();

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

    public void gameStatus(){
        if (!player1.shipList.contains(square.getStatus())){
            continueGame = false;
        } else if (!player2.shipList.contains(square.getStatus())){
            continueGame = false;
        }
    }

    public void fightPhase(){
        this.fightPhase = new FightPhase();
        while(continueGame){
            if (turn){
                player1.shootingLocation(player2);
                gameStatus();
                turn = false;
                Utils.pressAnyKeyToContinue();
            } else {
                player2.shootingLocation(player1);
                gameStatus();
                turn = true;
                Utils.pressAnyKeyToContinue();
            }

        }

    }


    //condition to endgame status switch
    private void updateGameStatus(){
    }



}
