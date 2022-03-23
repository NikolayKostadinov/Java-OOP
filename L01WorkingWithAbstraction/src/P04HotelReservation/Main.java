package P04HotelReservation;

import input.Reader;

public class Main {
    public static void main(String[] args) {
        String[] tokens = Reader.readStringArray("\\s+");
        double pricePerDay = Double.parseDouble(tokens[0]);
        int numberOfDays = Integer.parseInt(tokens[1]);
        Season season = Season.valueOf(tokens[2].toUpperCase());
        DiscountType discountType = DiscountType.parseDiscountType(tokens[3]);
        double price = PriceCalculator.Calculate(pricePerDay, numberOfDays, season, discountType);
        ConsolePrinter.print(price);
    }
}
