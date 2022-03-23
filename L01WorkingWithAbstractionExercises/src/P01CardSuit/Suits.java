package P01CardSuit;

public enum Suits {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private int value;

    Suits(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
