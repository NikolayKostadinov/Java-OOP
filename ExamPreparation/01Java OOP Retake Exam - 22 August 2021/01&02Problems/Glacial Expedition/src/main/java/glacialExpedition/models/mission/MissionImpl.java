package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        ArrayDeque<String> items = new ArrayDeque<>(state.getExhibits());
        List<Explorer> list = new ArrayList<>(explorers);
        for (Explorer explorer : list) {
            while (explorer.canSearch() && !items.isEmpty()) {
                String item = items.poll();
                explorer.getSuitcase().getExhibits().add(item);
                explorer.search();
                state.getExhibits().remove(item);
            }
            if (!explorer.canSearch()) {
                explorers.remove(explorer);
            }
            if (items.isEmpty()) {
                break;
            }
        }
    }
}
