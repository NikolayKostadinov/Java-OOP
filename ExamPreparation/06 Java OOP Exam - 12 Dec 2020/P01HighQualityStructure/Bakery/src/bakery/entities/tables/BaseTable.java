package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
    }

    protected void setCapacity(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }


    @Override
    public int getTableNumber() {
        return tableNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        this.price = this.pricePerPerson * this.numberOfPeople;
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        this.price = this.pricePerPerson * this.numberOfPeople;
        this.isReserved = true;
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        return this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum() +
                this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum();// +
                //this.price;
    }

    @Override
    public void clear() {
        this.drinkOrders.clear();
        this.foodOrders.clear();
        this.isReserved = false;
        this.numberOfPeople = 0;
        this.price = 0;
    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table: %d", tableNumber))
                .append(System.lineSeparator())
                .append(String.format("Type: %s", this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("Capacity: %d", this.capacity))
                .append(System.lineSeparator())
                .append(String.format("Price per Person: %.2f", pricePerPerson));

        return sb.toString();
    }
}
