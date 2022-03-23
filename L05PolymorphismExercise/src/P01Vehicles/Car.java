package P01Vehicles;

public class Car extends Vehicle {
    private static final Double ADDED_CONDITIONER_CONSUMPTION = 0.9;

    public Car(Double fuel, Double consumptionLitersPerKm) {
        super(fuel, consumptionLitersPerKm);
    }

    @Override
    protected Double getConditionerConsumptionCoefficient() {
        return ADDED_CONDITIONER_CONSUMPTION;
    }

    @Override
    public void refuel(double loadedFuel) {
        this.setFuel(this.getFuel() + loadedFuel);
    }
}
