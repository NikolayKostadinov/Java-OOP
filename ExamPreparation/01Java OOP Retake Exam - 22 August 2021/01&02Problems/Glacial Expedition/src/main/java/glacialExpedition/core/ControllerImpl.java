package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.ExplorerFactory;
import glacialExpedition.models.explorers.ExplorerFactoryImpl;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private final ExplorerFactory explorerFactory;
    private final ExplorerRepository explorerRepository;
    private final StateRepository stateRepository;
    private final Mission mission;
    private int exploredStatesCount;

    public ControllerImpl() {
        this.explorerFactory = new ExplorerFactoryImpl();
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = this.explorerFactory.getInstance(type, explorerName);
        this.explorerRepository.add(explorer);
        return String.format("Added %s: %s.", type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }

        this.stateRepository.add(state);

        return String.format("Added state: %s.", stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);
        if (explorer == null) {
            String message = String.format("Explorer %s doesn't exists.", explorerName);
            throw new IllegalArgumentException(message);
        }

        this.explorerRepository.remove(explorer);

        return String.format("Explorer %s has retired!", explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorersAboveFiftyEnergy = this.explorerRepository.getCollection().stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());
        if (explorersAboveFiftyEnergy.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        int countBeforeMission = explorersAboveFiftyEnergy.size();
        State stateByName = this.stateRepository.byName(stateName);
        Mission mission = new MissionImpl();
        mission.explore(stateByName, explorersAboveFiftyEnergy);
        exploredStatesCount++;
        int countAfterMission = explorersAboveFiftyEnergy.size();
        int retiredExplorers = countBeforeMission - countAfterMission;
        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, exploredStatesCount)).append(System.lineSeparator());
        sb.append("Information for the explorers:");
        Collection<Explorer> explorers = this.explorerRepository.getCollection();
        if (!explorers.isEmpty()) {
            sb.append(System.lineSeparator());
            sb.append(explorers
                    .stream()
                    .map(Explorer::toString)
                    .collect(Collectors.joining(System.lineSeparator())));
        }
        return sb.toString();
    }
}
