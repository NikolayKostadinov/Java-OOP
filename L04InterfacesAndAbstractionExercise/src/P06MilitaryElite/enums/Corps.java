package P06MilitaryElite.enums;

public enum Corps {
    AIRFORCES("Airforces"),
    MARINES("Marines");

    private String corpType;

    Corps(String corpType) {
        this.corpType = corpType;
    }

    public String getCorpType() {
        return corpType;
    }

    public static boolean isValidCorps(String corps) {
        return corps.equals(AIRFORCES.getCorpType()) || corps.equals(MARINES.getCorpType());
    }

    @Override
    public String toString () {
        return this.getCorpType();
    }
}
