package P06Animals;

import input.Reader;
import output.ConsolePrinter;
public class Main {
    public static void main(String[] args) {
        String animalType = Reader.readLine();
        AnimalFactory animalFactory = new AnimalFactory();

        while (!"Beast!".equals(animalType)) {
            try {
                String[] animalInfo = Reader.readStringArray("\\s+");
                Animal animal = animalFactory.Create(animalType, animalInfo);
                ConsolePrinter.printLine(animal.toString());
            } catch (IllegalArgumentException ex) {
                ConsolePrinter.printLine(ex.getMessage());
            }
            animalType = Reader.readLine();
        }

    }
}
