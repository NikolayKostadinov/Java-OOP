package P04BarracksWars.core.commands;

import P04BarracksWars.interfaces.Repository;
import P04BarracksWars.interfaces.UnitFactory;

public class Fight extends Command{
    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
