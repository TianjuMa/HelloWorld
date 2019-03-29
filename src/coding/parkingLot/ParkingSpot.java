package LaiOffer.parkingLot;

/**
 * Created by matinaju on 5/6/17.
 */


class ParkingSpot {
    /**
     * the vehicle size this spot can handle.
     */
    private final VehicleSize size;
    private Vehicle currentVehicle;

    ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    /**
     * check if this vehicle can park in this spot.
     *
     * @param v
     * @return
     */
    boolean fit(Vehicle v) {
        if (currentVehicle == null) {
            return size.ordinal() >= v.getSize().ordinal();
        }
        return false;
    }

    /**
     * record a vehicle is parked in by updating the currentVehicle field.
     *
     * @param v
     */
    void park(Vehicle v) {
        currentVehicle = v;
    }

    void leave() {
        currentVehicle = null;
    }

    Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
}
