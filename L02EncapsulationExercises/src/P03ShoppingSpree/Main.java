package P03ShoppingSpree;

import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Person> persons = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();
        try {
            readMap(scan.nextLine(), persons, tokens -> new Person(tokens[0], Integer.parseInt(tokens[1])));
            readMap(scan.nextLine(), products, tokens -> new Product(tokens[0], Integer.parseInt(tokens[1])));

            String input = scan.nextLine();

            while (!"END".equals(input)) {
                String[] tokens = input.split("\\s+");
                String personName = tokens[0];
                String productName = tokens[1];
                try {
                    persons.get(personName).buyProduct(products.get(productName));
                    System.out.printf("%s bought %s", personName, productName);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                input = scan.nextLine();
            }

            persons.entrySet()
                    .stream()
                    .forEach(p -> System.out.println(p.getValue()));

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static <T> void readMap(String records, Map<String, T> map, Function<String[], T> factory) {
        Arrays.stream(records.split(";"))
                .forEach(p -> {
                    String[] tokens = p.split("=");
                    map.put(tokens[0], factory.apply(tokens));
                });
    }

}
