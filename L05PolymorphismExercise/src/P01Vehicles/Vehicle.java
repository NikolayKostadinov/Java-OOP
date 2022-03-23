package P01Vehicles;

public abstract class Vehicle {
    private Double fuel;
    private Double consumptionLitersPerKm;

    public Vehicle(Double fuel, Double consumptionLitersPerKm) {
        this.setFuel(fuel);
        this.setConsumptionLitersPerKm(consumptionLitersPerKm);
    }

    public Double getFuel() {
        return fuel;
    }

    protected void setFuel(Double fuel) {
        this.fuel = fuel;
    }

    public Double getConsumptionLitersPerKm() {
        return consumptionLitersPerKm;
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
    public abstract void refuel(double loadedFuel);

}
