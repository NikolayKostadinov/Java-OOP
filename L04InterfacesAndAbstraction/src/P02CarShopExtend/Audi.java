package P02CarShopExtend;

public class Audi extends CarImpl implements Rentable {
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower,
                String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return null;
    }

    @Override
    public Double getPricePerDay() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString()
                + System.lineSeparator()
                + String.format("Minimum rental period of %d days. Price per day %.6f",
                this.minRentDay, this.pricePerDay);
    }
}
