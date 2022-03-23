package P06GreedyTimes;

public enum ItemType {
    GOLD("Gold"),
    GEM("Gem"),
    CASH("Cash"),
    OTHER("Other");

    private String displayText;

    ItemType(String displayText) {
        this.displayText = displayText;
    }

    public static ItemType parseItemType(String input) {
        if (input.length() == 3) {
            return CASH;
        } else if (input.toLowerCase().endsWith("gem")) {
            return GEM;
        } else if (input.toLowerCase().equals("gold")) {
            return GOLD;
        }
        return OTHER;
    }


    public String getDisplayText(){
        return this.displayText;
    }
}
