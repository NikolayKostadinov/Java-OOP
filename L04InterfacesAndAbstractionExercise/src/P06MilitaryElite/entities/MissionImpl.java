package P06MilitaryElite.entities;

import P06MilitaryElite.enums.State;
import P06MilitaryElite.interfaces.Mission;

public class MissionImpl implements Mission {
    private String codeName;
    private State state;

    public MissionImpl(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    public String getCodeName() {
        return codeName;
    }

    public void completeMission(){
        this.state = State.FINISHED;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state.toString());
    }
}
