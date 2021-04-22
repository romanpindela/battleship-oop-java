package game.Ship;

public class ShipFormula {
    int[] startCoord00;
    ShipType.shipType shipType;
    ShipType.shipOrientation shipOrientation;
    PlacingDirection.placingDirection placingDirection;

    public ShipFormula(int[] startCoord00,
                       ShipType.shipType shipType,
                       ShipType.shipOrientation shipOrientation) {

        this.startCoord00 = startCoord00;
        this.shipType = shipType;
        this.shipOrientation = shipOrientation;

        this.placingDirection = PlacingDirection.placingDirection.Right;
    }

    public void revertPlacingDirection(){
        this.placingDirection = PlacingDirection.placingDirection.Left;
    }

    public ShipFormula(){

    }
}
