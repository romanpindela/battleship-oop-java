package game.Battleship;

import game.Display.Display;
import game.Input.Input;

import java.sql.SQLOutput;

public class Battleship {
    protected Display display;
    protected Input input;

    public Battleship() {
        this.display = new Display();
        this.input = new Input();
    }

    public void run() {
        boolean exit = false;
        int gameFlow = 0;

        while(!exit){
            switch(gameFlow){
                case 0:
                    gameFlow = showMenu();
                    break;
                case 1:
                case 2:
                case 3:
                    startNewGame(gameFlow);
                    gameFlow = 0;
                    break;
                case 4:
                    displayHighscores();
                    gameFlow = 0;
                    break;
                case 5:
                    exit = true;
                    break;

            }
        }

    }


    private int showMenu() {
        return this.display.gameMenu();
    }

    private void startNewGame(int modeGame) {
        System.out.println("Starting new game..");
    }

    private void displayHighscores() {
        System.out.println("Displaying highscores..");
    }
}

