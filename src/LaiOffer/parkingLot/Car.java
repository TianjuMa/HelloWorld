package LaiOffer.parkingLot;

/**
 * Created by matinaju on 5/6/17.
 */
public class Car extends Vehicle {
    @Override
    public VehicleSize getSize() {
        return VehicleSize.Compact;
    }
}
