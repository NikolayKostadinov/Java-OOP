package P03BarracksWars.core.commands;

import P03BarracksWars.interfaces.Repository;
import P03BarracksWars.interfaces.Unit;
import P03BarracksWars.interfaces.UnitFactory;

public class AddUnitCommand extends Command {
    public AddUnitCommand(String[] data, Repository repository, UnitFactory unitFactory) {
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
