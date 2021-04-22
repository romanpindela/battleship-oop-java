package game.Board;

import game.Settings.Settings;

public class Square {
    int x;
    int y;

    public SquareStatus.squareStatus status;

    public Square(int x, int y, SquareStatus.squareStatus initStatus) {
        this.x = x;
        this.y = y;
        this.status = initStatus;
    }

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = SquareStatus.squareStatus.EMPTY;
    }


    public Square() {
        this.x = 0;
        this.y = 0;
        this.status = Settings.defaultSquareStatus;
    }


    public char getStatus() {
        return SquareStatus.getCharacter(status);
    }


    public int getX() {
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
