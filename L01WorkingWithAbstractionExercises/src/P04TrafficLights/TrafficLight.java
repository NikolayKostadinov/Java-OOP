package P04TrafficLights;

public class TrafficLight {
    private Colors color;

    public TrafficLight(Colors colors) {
        this.color = colors;
    }

    public Colors getColor() {
        this.nextColor();
        return this.color;
    }

    private void nextColor() {
        switch (this.color){
            case RED:
                this.color = Colors.GREEN;
                break;
            case GREEN:
                this.color = Colors.YELLOW;
                break;
            case YELLOW:
                this.color = Colors.RED;
                break;
            default:
                throw new IllegalStateException();
        }
    }
}
