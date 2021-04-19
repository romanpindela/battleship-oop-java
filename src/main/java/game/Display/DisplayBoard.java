package game.Display;

import game.Settings.Settings;
import  java.util.ArrayList;

public class DisplayBoard extends Display{

    public void drawBoard(){
        int boardSize = Settings.boardSize;
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
              System.out.print(Settings.signEmpty);
            }
            System.out.println("");
        }
    }
}
