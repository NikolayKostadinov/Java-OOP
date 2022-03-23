package P03WildFarm;

public class Tiger extends Felime{

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food){
        if (food instanceof Meat){
            super.eat(food);
        } else {
            String message = String.format("%s are not eating that type of food!", this.getAnimalType());
            throw new IllegalArgumentException(message);
        }
    }
}
