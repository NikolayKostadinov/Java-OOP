package P02VehiclesExtension;

public class Bus extends Vehicle {
    private static final Double ADDED_CONDITIONER_CONSUMPTION = 1.4;

    private boolean isEmpty;

    public Bus(Double fuel, Double consumptionLitersPerKm, Double tankCapacity) {
        super(fuel, consumptionLitersPerKm, tankCapacity);
    }

    @Override
    protected Double getConditionerConsumptionCoefficient() {
        return this.isEmpty ? 0 : ADDED_CONDITIONER_CONSUMPTION;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
