package P03BirthdayCelebrations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] parameters = scan.nextLine().split("\\s+");
        List<Birthable> birthables = new ArrayList<>();
        while (!"End".equals(parameters[0])) {
            switch (parameters[0]) {
                case "Citizen":
                    String name = parameters[1];
                    int age = Integer.parseInt(parameters[2]);
                    String id = parameters[3];
                    String birthdate = parameters[4];
                    birthables.add(new Citizen(name, age, id, birthdate));
                    break;
                case "Pet":
                    name = parameters[1];
                    birthdate = parameters[2];
                    birthables.add(new Pet(name, birthdate));
            }
            parameters = scan.nextLine().split("\\s+");
        }

        String targetYear = scan.nextLine();

        birthables.stream()
                .filter(x->x.getBirthDate().endsWith(targetYear))
                .map(x->x.getBirthDate())
                .forEach(System.out::println);

    }
}
