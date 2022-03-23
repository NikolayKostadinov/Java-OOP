package P04BarracksWars.core.commands;

import P04BarracksWars.interfaces.Repository;
import P04BarracksWars.interfaces.Unit;
import P04BarracksWars.interfaces.UnitFactory;

public class Add extends Command{
    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
