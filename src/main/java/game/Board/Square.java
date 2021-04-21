package game.Board;

import game.Settings.Settings;

public class Square {
    char x;
    int y;

    SquareStatus.squareStatus status;

    public Square(char x, int y, SquareStatus.squareStatus initStatus) {
        this.x = x;
        this.y = y;
        this.status = initStatus;
    }

    public Square() {
        this.x = 0;
        this.y = 0;
        this.status = Settings.defaultSquareStatus;
    }


    public char getStatus() {
        return SquareStatus.getCharacter(status);
    }


    public char getX() {
        return x;
    }

    public void setX(char x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStatus(SquareStatus.squareStatus status) {
        this.status = status;
    }
}
