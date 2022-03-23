package P04PizzaCalories;

import java.util.Locale;

public class Dough {
    private static final Double CALORIE_BASE = 2.0;
    private String flourType;
    private String bakingTechnique;
    private double weight;
    private FlourType flourTypeModifier;
    private BakingTechnique bakingTechniqueModifier;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public void setWeight(double weight) {
        if (1 > weight || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public void setFlourType(String flourType) {
        this.flourType = flourType;
        try {
            this.flourTypeModifier = FlourType.valueOf(flourType.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public void setBakingTechnique(String bakingTechnique) {
        this.bakingTechnique = bakingTechnique;
        try {
            this.bakingTechniqueModifier = BakingTechnique.valueOf(bakingTechnique.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories() {
        return  this.weight
                * CALORIE_BASE
                * this.flourTypeModifier.getModifier()
                * this.bakingTechniqueModifier.getModifier();
    }
}
