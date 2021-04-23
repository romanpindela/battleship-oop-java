package game.Battleship;

import game.Board.Square;
import game.Board.SquareStatus;
import game.Ship.Ship;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FightPhase extends Game{
    public boolean lost;

    public FightPhase() {
    }


    public void fight() {

    }

    public boolean checkEndGame(){
        return this.lost;
    }

    public static void checkIfShipIsDestroyed (Ship targetedShip){

        List<Square> hitSquares =
                targetedShip.squares.stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList())
                        .stream()
                        .filter(square -> square.status == SquareStatus.squareStatus.HIT)
                        .collect(Collectors.toList());

        if (hitSquares.size() == targetedShip.squares.size()) {
            for (int i = 0; i< targetedShip.squares.size(); i++){
                targetedShip.squares.get(i).setStatus(SquareStatus.squareStatus.DESTROYED);
            }

        }

    }

    /*

    public List<Square> findEmptySquares(ArrayList<ArrayList<Square>> boardOfSquares) {
        List<Square> emptySquares =
                boardOfSquares.stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList())
                        .stream()
                        .filter(square -> square.status == SquareStatus.squareStatus.EMPTY)
                        .collect(Collectors.toList());

        return emptySquares;
    }

     */
}
