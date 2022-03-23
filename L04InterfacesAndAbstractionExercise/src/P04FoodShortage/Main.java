package P04FoodShortage;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scan.nextLine());

        Map<String, Buyer> buyers = new HashMap<>();

        while (numberOfPeople-- > 0){
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            if (tokens.length == 4){
                String id = tokens[2];
                String birthDate = tokens[3];
                buyers.putIfAbsent(name, new Citizen(name,age,id,birthDate));
            } else {
                String group = tokens[2];
                buyers.putIfAbsent(name, new Rebel<>(name,age,group));
            }
        }

        String name = scan.nextLine();
        while (!"End".equals(name)){
            if (buyers.containsKey(name)){
                buyers.get(name).buyFood();
            }
            name = scan.nextLine();
        }

        System.out.println(buyers.entrySet()
                .stream()
                .mapToInt(b -> b.getValue().getFood())
                .sum());

    }
}
