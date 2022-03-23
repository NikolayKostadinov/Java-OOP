package P03BarracksWars;

import P03BarracksWars.data.UnitRepository;
import P03BarracksWars.interfaces.Repository;
import P03BarracksWars.core.Engine;
import P03BarracksWars.core.factories.UnitFactoryImpl;
import P03BarracksWars.interfaces.Runnable;
import P03BarracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
