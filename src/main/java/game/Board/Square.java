package game.Board;

public class Square {
    char x;
    int y;

    SquareStatus.squareStatus status;

    public char getStatus() {
        return SquareStatus.getCharacter(status);
    }

}
