package LaiOffer.parkingLot;

/**
 * Created by matinaju on 5/6/17.
 */
public class ParkingLot {
    private final Level[] levels;

    public ParkingLot(int numOfLevels, int numOfPerLevel) {
        levels = new Level[numOfLevels];
        for (int i = 0; i < numOfLevels; i++) {
            levels[i] = new Level(numOfPerLevel);
        }
    }

    public boolean hasSpot(Vehicle v) {
        for (Level l : levels) {
            if (l.hasSpot(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean park(Vehicle v) {
        for (Level l : levels) {
            if (l.park(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean leave(Vehicle v) {
        for (Level l : levels) {
            if (l.leave(v)) {
                return true;
            }
        }
        return false;
    }
}
