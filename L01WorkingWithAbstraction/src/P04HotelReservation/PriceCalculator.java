package P04HotelReservation;

import java.util.Locale;

public class PriceCalculator {
    public static double Calculate(double pricePerDay, int numberOfDays, Season season, DiscountType discountType) {
        int discountPercent = discountType.getPercent();
        int seasonCoefficient = season.getValue();
        return pricePerDay * numberOfDays * seasonCoefficient * (100 - discountPercent) / 100.0;
    }
}
