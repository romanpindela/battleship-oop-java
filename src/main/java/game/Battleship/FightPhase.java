package game.Battleship;

public class FightPhase extends Game{
    private boolean lost;

    public FightPhase() {
    }


    public boolean checkEndGame(){
        return this.lost;
    }



}
