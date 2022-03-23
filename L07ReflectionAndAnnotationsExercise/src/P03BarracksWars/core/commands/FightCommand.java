package P03BarracksWars.core.commands;

import P03BarracksWars.interfaces.Repository;
import P03BarracksWars.interfaces.UnitFactory;

public class FightCommand extends Command {
    public FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
