package P01Vehicles;

public class Truck extends Vehicle {
    private static final Double CONDITIONER_CONSUMPTION_COEFFICIENT = 1.6;
    private static final Double HOLE_DECREASE = 0.95;

    public Truck(Double fuel, Double consumptionLitersPerKm) {
        super(fuel, consumptionLitersPerKm);
    }

    @Override
    protected Double getConditionerConsumptionCoefficient() {
        return CONDITIONER_CONSUMPTION_COEFFICIENT;
    }


    @Override
    public void refuel(double loadedFuel) {
        this.setFuel(this.getFuel() + loadedFuel * HOLE_DECREASE);
    }
}
