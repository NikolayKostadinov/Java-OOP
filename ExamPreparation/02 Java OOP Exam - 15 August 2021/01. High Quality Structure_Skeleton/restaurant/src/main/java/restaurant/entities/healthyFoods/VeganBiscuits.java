package restaurant.entities.healthyFoods;

public class VeganBiscuits extends Food{
    private static final double INITIAL_SALAD_PORTION = 205;
    protected VeganBiscuits(String name, double price) {
        super(name, INITIAL_SALAD_PORTION, price);
    }
}
