package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.AstronautFactory;
import spaceStation.models.astronauts.AstronautFactoryImpl;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST;
import static spaceStation.common.ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS;

public class ControllerImpl implements Controller {
    private final AstronautFactory astronautFactory;
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private Mission mission;
    private int exploredPlanetsCount;

    public ControllerImpl() {
        this.astronautFactory = new AstronautFactoryImpl();
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = this.astronautFactory.getInstance(type, astronautName);
        this.astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            planet.getItems().add(item);
        }
        this.planetRepository.add(planet);

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = this.astronautRepository.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        this.astronautRepository.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> astronauts = this.astronautRepository.getModels()
                .stream()
                .filter(astronaut -> astronaut.getOxygen() > 60)
                .collect(Collectors.toList());
        if (astronauts.isEmpty()){
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Planet planet = this.planetRepository.findByName(planetName);
        mission.explore(planet, astronauts);
        exploredPlanetsCount ++;
        long deadAstronauts = astronauts.stream().filter(a -> a.getOxygen() == 0).count();
        return String.format(PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, exploredPlanetsCount)).append(System.lineSeparator());
        sb.append(REPORT_ASTRONAUT_INFO);
        if (!this.astronautRepository.getModels().isEmpty())
        {
            sb.append(System.lineSeparator());
            sb.append(this.astronautRepository.getModels()
                    .stream()
                    .map(Astronaut::toString)
                    .collect(Collectors.joining(System.lineSeparator())));
        }
        return sb.toString();
    }
}
