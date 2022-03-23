package P03WildFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            Animal animal = createAnimal(input);
            Food food = createFood(scan.nextLine());
            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println(animal);
            input = scan.nextLine();
        }
    }

    private static Food createFood(String input) {
        String[] tokens = input.split("\\s+");
        int quantity = Integer.parseInt(tokens[1]);
        switch (tokens[0]) {
            case "Vegetable":
                return new Vegetable(quantity);
            case "Meat":
                return new Meat(quantity);
            default:
                return null;
        }
    }

    private static Animal createAnimal(String input) {
        String[] tokens = input.split("\\s+");
        String animalType = tokens[0];
        String animalName = tokens[1];
        Double animalWeight = Double.parseDouble(tokens[2]);
        String animalLivingRegion = tokens[3];

        switch (tokens[0]) {
            case "Mouse":
                return new Mouse(animalType, animalName, animalWeight, animalLivingRegion);
            case "Zebra":
                return new Zebra(animalType, animalName, animalWeight, animalLivingRegion);
            case "Cat":
                String bread = tokens[4];
                return new Cat(animalType, animalName, animalWeight, animalLivingRegion, bread);
            case "Tiger":
                return new Tiger(animalType, animalName, animalWeight, animalLivingRegion);
            default:
                return null;
        }
    }
}
