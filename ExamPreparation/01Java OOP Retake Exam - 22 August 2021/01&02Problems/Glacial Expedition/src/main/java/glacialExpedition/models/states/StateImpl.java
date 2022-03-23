package glacialExpedition.models.states;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StateImpl implements State{
    private String name;
    private final List<String> exhibits;

    public StateImpl(String name) {
        this.setName(name);
        this.exhibits = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Invalid name!");
        }
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
