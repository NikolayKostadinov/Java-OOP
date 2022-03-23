package P02VehiclesExtension;

public abstract class Vehicle {
    private Double fuel;
    private Double consumptionLitersPerKm;
    private Double tankCapacity ;

    public Vehicle(Double fuel, Double consumptionLitersPerKm, Double tankCapacity) {
        this.setTankCapacity(tankCapacity);
        this.fuel = fuel;
        this.setConsumptionLitersPerKm(consumptionLitersPerKm);
    }

    public Double getFuel() {
        return fuel;
    }

    protected void setFuel(Double fuel) {
        validateFuel(fuel);
        this.fuel = fuel;
    }

    private void validateFuel(Double fuel) {
        if (fuel < 0) throw new IllegalArgumentException("Fuel must be a positive number");
        if (fuel > this.tankCapacity) throw new IllegalArgumentException("Cannot fit fuel in tank");
    }

    protected Double getConsumptionLitersPerKm() {
        return consumptionLitersPerKm;
    }

    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected abstract Double getConditionerConsumptionCoefficient();

    protected void setConsumptionLitersPerKm(Double consumptionLitersPerKm) {
        this.consumptionLitersPerKm = consumptionLitersPerKm + this.getConditionerConsumptionCoefficient();
    }

    public boolean drive(double kilometers){
        double consumption = this.consumptionLitersPerKm * kilometers;
        if (consumption <= this.fuel){
            this.fuel -= consumption;
            return true;
        }

        return false;
    }

    public void refuel(double loadedFuel){
        validateFuel(loadedFuel);
        this.setFuel(this.fuel + loadedFuel);
    };

    private void validateFuel(double fuel) {
        if (fuel <= 0) throw new IllegalArgumentException("Fuel must be a positive number");
        if (fuel > this.tankCapacity) throw new IllegalArgumentException("Cannot fit fuel in tank");
    }

}
