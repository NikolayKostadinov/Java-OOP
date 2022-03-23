package glacialExpedition.models.states;

import glacialExpedition.models.suitcases.Suitcase;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Carton implements Suitcase {

    private final List<String> exhibits;

    public Carton() {
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }
}
