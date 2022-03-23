package P02VehiclesExtension;

public class Truck extends Vehicle {
    private static final Double ADDED_CONDITIONER_CONSUMPTION = 1.6;
    private static final Double HOLE_DECREASE = 0.95;

    public Truck(Double fuel, Double consumptionLitersPerKm, Double tankCapacity) {
        super(fuel, consumptionLitersPerKm, tankCapacity);
    }

    @Override
    protected Double getConditionerConsumptionCoefficient() {
        return ADDED_CONDITIONER_CONSUMPTION;
    }


    @Override
    public void refuel(double loadedFuel) {
        super.refuel(loadedFuel * HOLE_DECREASE);
    }
}
