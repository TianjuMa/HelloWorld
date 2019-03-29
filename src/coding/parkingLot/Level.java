package coding.parkingLot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by matinaju on 5/6/17.
 */
class Level {
    private final List<ParkingSpot> spots;

    /**
     * one half of spots are used for small size, the other half are used for large vehicle.
     * attention: make this list unmodifiable manually.
     *
     * @param numOfSpots the number of spots in this level.
     */
    Level(int numOfSpots) {
        List<ParkingSpot> list = new ArrayList<>(numOfSpots);
        int i = 0;
        for (; i < numOfSpots / 2; i++) {
            list.add(new ParkingSpot(VehicleSize.Compact));
        }
        for (; i < numOfSpots; i++) {
            list.add(new ParkingSpot(VehicleSize.Large));
        }
        spots = Collections.unmodifiableList(list);
    }

    boolean hasSpot(Vehicle v) {
        for (ParkingSpot ps : spots) {
            if (ps.fit(v)) {
                return true;
            }
        }
        return false;
    }

    boolean park(Vehicle v) {
        for (ParkingSpot ps : spots) {
            if (ps.fit(v)) {
                ps.park(v);
                return true;
            }
        }
        return false;
    }

    boolean leave(Vehicle v) {
        for (ParkingSpot ps : spots) {
            if (ps.getCurrentVehicle() == v) {
                ps.leave();
                return true;
            }
        }
        return false;
    }
}
