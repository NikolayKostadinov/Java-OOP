package P04PizzaCalories;

import java.util.Locale;

public class Topping {
    private static final Double CALORIE_BASE = 2.0;
    private String toppingType;
    private ToppingType toppingTypeModifier;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (1 > weight || weight > 50) {
            String message = String.format("%s weight should be in the range [1..50].", this.toppingType);
            throw new IllegalArgumentException(message);
        }

        this.weight = weight;
    }

    private void setToppingType(String toppingType) {
        try {
            this.toppingType = toppingType;
            this.toppingTypeModifier = ToppingType.valueOf(toppingType.toUpperCase());
        } catch (IllegalArgumentException ex) {
            String message = String.format("Cannot place %s on top of your pizza.", toppingType);
            throw new IllegalArgumentException(message);
        }
    }

    public double calculateCalories() {
        return this.weight
                * CALORIE_BASE
                * this.toppingTypeModifier.getModifier();
    }
}
