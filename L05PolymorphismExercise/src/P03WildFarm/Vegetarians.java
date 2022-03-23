package P03WildFarm;

public abstract class Vegetarians extends Mammal {


    public Vegetarians(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable){
            super.eat(food);
        } else {
            String message = String.format("%s are not eating that type of food!", this.getAnimalType());
            throw new IllegalArgumentException(message);
        }
    }
}
