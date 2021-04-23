package game.Display;

import game.Settings.Settings;
import  java.util.ArrayList;
import game.Board.*;

public class DisplayBoard extends Display{

    public void displayBoard(Board board){
        int boardSize = board.getSize();
        char[] rowNames = Settings.rowNames.substring(0,boardSize).toCharArray();

        for(int columnIndex = 0; columnIndex < boardSize; columnIndex++){
            if(columnIndex == 0){
                System.out.print("  ");
            };
            System.out.print(columnIndex + 1 + " ");
        }
        System.out.println("");

        for(int rowIndex = 0; rowIndex < boardSize; rowIndex++){
            System.out.print(rowNames[rowIndex] + " ");
            for(int columnIndex = 0; columnIndex < boardSize; columnIndex++){
                System.out.print(
                                colorBoard(board.getBoard().get(rowIndex).get(columnIndex).getStatus()) + " "
                        );
            }
            System.out.println("");
        }
    }

    private String colorBoard(char s) {
        return switch(s){
            case 'H' -> ANSI_RED + s + ANSI_RESET;
            case 'M' -> ANSI_CYAN + s + ANSI_RESET;
            case '~' -> ANSI_BLUE + s + ANSI_RESET;
            case 'D' -> ANSI_PURPLE + s + ANSI_RESET;
            case 'S' -> ANSI_YELLOW + s + ANSI_RESET;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }
}
