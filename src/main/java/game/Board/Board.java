package game.Board;

import java.util.ArrayList;
import game.Settings.Settings;

public class Board {
    public ArrayList<ArrayList<Square>> getBoard() {
        return board;
    }

    ArrayList<ArrayList<Square>> board;

    public int getSize() {
        return size;
    }

    int size;

    public Board() {
        this.size = Settings.globalBoardSize;
        char[] rowNames = Settings.rowNames.substring(0,size).toCharArray();
        SquareStatus.squareStatus defaultStatus = Settings.defaultSquareStatus;
        this.board = new ArrayList<ArrayList<Square>>();

        for (int rowSquareIndex = 0; rowSquareIndex < size; rowSquareIndex++) {
            for (int columnSquareIndex = 0; columnSquareIndex < size; columnSquareIndex++) {
                this.board.add(new ArrayList<Square>());
                this.board.get(rowSquareIndex)
                        .add(new Square(rowNames[rowSquareIndex], columnSquareIndex, defaultStatus));
            }
        }

    }


    public static void isPlacementValid(){

    }

    

}
