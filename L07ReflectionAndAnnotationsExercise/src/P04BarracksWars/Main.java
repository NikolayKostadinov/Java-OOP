package P04BarracksWars;

import P04BarracksWars.interfaces.Repository;
import P04BarracksWars.interfaces.Runnable;
import P04BarracksWars.interfaces.UnitFactory;
import P04BarracksWars.core.Engine;
import P04BarracksWars.core.factories.UnitFactoryImpl;
import P04BarracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
