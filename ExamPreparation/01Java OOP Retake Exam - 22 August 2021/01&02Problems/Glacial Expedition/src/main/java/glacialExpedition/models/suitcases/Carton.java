package glacialExpedition.models.suitcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;

public class Carton implements Suitcase{
    private final List<String> exhibits;

    public Carton() {
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String toString() {
        return String.format("Suitcase exhibits: %s", this.exhibits
                .stream()
                .collect(Collectors.joining(", ")));
    }
}
