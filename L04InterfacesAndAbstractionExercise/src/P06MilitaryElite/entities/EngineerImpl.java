package P06MilitaryElite.entities;

import P06MilitaryElite.enums.Corps;
import P06MilitaryElite.interfaces.Engineer;
import P06MilitaryElite.interfaces.Repair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private final List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Repairs:" + (this.repairs.isEmpty() ? "" : System.lineSeparator() +
                this.repairs.stream()
                        .map(r ->  "  " + r.toString())
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
