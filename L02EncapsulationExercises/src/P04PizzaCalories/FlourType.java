package P04PizzaCalories;

public enum FlourType {
    WHITE(1.5), WHOLEGRAIN(1.0);
    private double modifier;

    FlourType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
}
