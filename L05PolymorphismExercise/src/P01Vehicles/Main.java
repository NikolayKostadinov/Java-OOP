package P01Vehicles;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Map<String, Vehicle> vehicles = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        createCar(scan, vehicles);
        createTruck(scan, vehicles);

        int count = Integer.parseInt(scan.nextLine());

        while (count-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String vehicleType = tokens[1];
            Double quantity = Double.parseDouble(tokens[2]);
            switch (tokens[0]) {
                case "Drive":
                    drive(vehicleType, quantity);
                    break;
                case "Refuel":
                    refuel(vehicleType, quantity);
                    break;
            }
        }

        System.out.println(vehicles
                .entrySet()
                .stream()
                .map(v -> String.format("%s: %.2f", v.getValue().getClass().getSimpleName(), v.getValue().getFuel()))
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static void refuel(String vehicleType, Double quantity) {
        vehicles.get(vehicleType).refuel(quantity);
    }

    private static void drive(String vehicleType, Double distance) {
        if (vehicles.get(vehicleType).drive(distance)) {
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.printf("%s travelled %s km%n", vehicleType, df.format(distance));
        } else {
            System.out.printf("%s needs refueling%n", vehicleType);
        }
    }

    private static void createTruck(Scanner scan, Map<String, Vehicle> vehicles) {
        String[] params = scan.nextLine().split("\\s+");
        double fuel = Double.parseDouble(params[1]);
        double consumption = Double.parseDouble(params[2]);
        vehicles.putIfAbsent("Truck", new Truck(fuel, consumption));
    }

    private static void createCar(Scanner scan, Map<String, Vehicle> vehicles) {
        String[] params = scan.nextLine().split("\\s+");
        double fuel = Double.parseDouble(params[1]);
        double consumption = Double.parseDouble(params[2]);
        vehicles.putIfAbsent("Car", new Car(fuel, consumption));
    }

}
