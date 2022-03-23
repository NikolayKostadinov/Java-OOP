package P02VehiclesExtension;

public class Car extends Vehicle {
    private static final Double ADDED_CONDITIONER_CONSUMPTION = 0.9;

    public Car(Double fuel, Double consumptionLitersPerKm, Double tankCapacity) {
        super(fuel, consumptionLitersPerKm, tankCapacity);
    }

    @Override
    protected Double getConditionerConsumptionCoefficient() {
        return ADDED_CONDITIONER_CONSUMPTION;
    }
}
