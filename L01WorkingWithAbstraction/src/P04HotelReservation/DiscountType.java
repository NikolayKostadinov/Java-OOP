package P04HotelReservation;

public enum DiscountType {
    VIP(20),
    SECOND_VISIT(10),
    NONE(0);

    private int percent;

    DiscountType(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }

    public static DiscountType parseDiscountType(String discount) {
        switch (discount) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalStateException();
        }
    }
}
