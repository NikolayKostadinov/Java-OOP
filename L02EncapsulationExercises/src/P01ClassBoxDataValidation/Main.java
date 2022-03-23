package P01ClassBoxDataValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double length = Double.parseDouble(scan.nextLine());
        double width =  Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());

        try {
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
            System.out.printf("Volume – %.2f%n", box.calculateVolume());

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
