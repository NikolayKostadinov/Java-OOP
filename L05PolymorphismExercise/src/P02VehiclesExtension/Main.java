package P02VehiclesExtension;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static Map<String, Vehicle> vehicles = new LinkedHashMap<>();

    public static void main(String[] args) {

        readVehicles();

        int count = Integer.parseInt(scan.nextLine());

        while (count-- > 0) {
            try {
                String[] tokens = scan.nextLine().split("\\s+");
                String vehicleType = tokens[1];
                Double quantity = Double.parseDouble(tokens[2]);
                switch (tokens[0]) {
                    case "Drive":
                        drive(vehicleType, quantity);
                        break;
                    case "DriveEmpty":
                        driveEmpty(vehicleType, quantity);
                        break;
                    case "Refuel":
                        refuel(vehicleType, quantity);
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(vehicles
                .entrySet()
                .stream()
                .map(v -> String.format("%s: %.2f", v.getValue().getClass().getSimpleName(), v.getValue().getFuel()))
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static void readVehicles() {
        for (int i = 0; i < 3; i++) {
            String[] params = scan.nextLine().split("\\s+");
            String vehicleType = params[0];
            double fuel = Double.parseDouble(params[1]);
            double consumption = Double.parseDouble(params[2]);
            double tankCapacity = Double.parseDouble(params[3]);
            vehicles.putIfAbsent(vehicleType, createVehicle(vehicleType, fuel, consumption, tankCapacity));
        }
    }

    private static void driveEmpty(String vehicleType, Double quantity) {
        Bus bus = (Bus) vehicles.get(vehicleType);
        bus.setEmpty(true);
        drive(vehicleType, quantity);
        bus.setEmpty(false);
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

    private static Vehicle createVehicle(String vehicleType, double fuel, double consumption, double tankCapacity) {
           switch (vehicleType) {
            case "Car":
                return new Car(fuel, consumption, tankCapacity);
            case "Truck":
                return new Truck(fuel, consumption, tankCapacity);
            case "Bus":
                return new Bus(fuel, consumption, tankCapacity);
            default:
                return null;
        }
    }
}
