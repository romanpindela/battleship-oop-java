package game.Ship;

import java.util.Arrays;

public class PlacingDirection {
    public enum placingDirection{
        Left, Right, Up, Down
    }

    public static int getPlacingDirectionFactor(PlacingDirection.placingDirection placingDirection){
        if(Arrays.asList(PlacingDirection.placingDirection.Left,
                PlacingDirection.placingDirection.Up).contains(placingDirection)){
            return -1;
        } else { return 1; }
    }

}
