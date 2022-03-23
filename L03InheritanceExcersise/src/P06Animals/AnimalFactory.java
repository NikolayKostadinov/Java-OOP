package P06Animals;

import java.util.Arrays;

public class AnimalFactory {
    private static final int CONSTRUCTOR_PARAMS_COUNT = 3;

    public Animal Create(String animalKind, String[] animalInfo) {
        String name = animalInfo[0];
        int age = Integer.parseInt(animalInfo[1]);
        String gender = animalInfo[2];

        switch (animalKind) {
            case "Animal":
                return new Animal(name, age, gender);
            case "Cat":
                return new Cat(name, age, gender);
            case "Dog":
                return new Dog(name, age, gender);
            case "Frog":
                return new Frog(name, age, gender);
            case "Kitten":
                return new Kitten(name, age);
            case "Tomcat":
                return new Tomcat(name, age);
            default:
                throw new IllegalArgumentException("Invalid input!");
        }
    }
}
