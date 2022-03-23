package P04BarracksWars.core.commands;

import P04BarracksWars.interfaces.Repository;
import P04BarracksWars.interfaces.UnitFactory;

public class Retire extends Command{
    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        String message = String.format("%s retired!",unitType);
        try{
            this.getRepository().removeUnit(unitType);
        } catch (IllegalArgumentException ex){
            message = ex.getMessage();
        }

        return message;
    }
}
