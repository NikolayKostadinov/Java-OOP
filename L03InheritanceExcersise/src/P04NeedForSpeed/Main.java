package P04NeedForSpeed;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Vehicle(20, 10).getFuelConsumption());
        System.out.println(new SportCar (20, 10).getFuelConsumption());
        System.out.println(new RaceMotorcycle(20, 10).getFuelConsumption());
        System.out.println(new Car (20, 10).getFuelConsumption());
    }
}
