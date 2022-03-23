package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
    }

    protected void setSize(int size) {
        if (size < 0){
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    protected void setNumberOfPeople(int numberOfPeople) {
    if (numberOfPeople <= 0){
        throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
    }
        this.numberOfPeople = numberOfPeople;
    }

    private void calculateAllPeople() {
        this.allPeople = this.numberOfPeople * this.pricePerPerson;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReservedTable = true;
        this.setNumberOfPeople(numberOfPeople);
        calculateAllPeople();
    }

    @Override
    public void orderHealthy(HealthyFood food) {

        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {

        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double priceOfFood = this.healthyFood
                .stream()
                .mapToDouble(HealthyFood::getPrice)
                .sum();
        double priceOfBeverages = this.beverages
                .stream()
                .mapToDouble(Beverages::getPrice)
                .sum();
        return this.allPeople + priceOfFood + priceOfBeverages;
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.numberOfPeople = 0;
        this.isReservedTable = false;
        calculateAllPeople();
    }

    @Override
    public String tableInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table - %d", this.number)).append(System.lineSeparator());
        sb.append(String.format("Size - %d", this.size)).append(System.lineSeparator());
        sb.append(String.format("Type  - %s", this.getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("All price - %.2f", this.pricePerPerson));
        return sb.toString();
    }
}
