package P06MilitaryElite.enums;

public enum State {
    INPROGRESS("inProgress"),
    FINISHED("finished");

    private String state;

    State(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public static boolean isValidState(String state) {
        return state.equals(INPROGRESS.getState()) || state.equals(FINISHED.getState());
    }

    @Override
    public String toString() {
        return this.getState();
    }
}