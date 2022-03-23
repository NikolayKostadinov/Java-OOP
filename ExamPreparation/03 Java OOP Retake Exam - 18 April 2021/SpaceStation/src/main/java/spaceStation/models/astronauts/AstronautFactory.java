package spaceStation.models.astronauts;

public interface AstronautFactory {
    Astronaut getInstance(String type, String astronautName);
}
