package spaceStation.models.astronauts;

import spaceStation.common.ExceptionMessages;

public class AstronautFactoryImpl implements AstronautFactory {
    @Override
    public Astronaut getInstance(String type, String astronautName) {
        switch (type) {
            case "Biologist":
                return new Biologist(astronautName);
            case "Geodesist":
                return new Geodesist(astronautName);
            case "Meteorologist":
                return new Meteorologist(astronautName);
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
    }
}
