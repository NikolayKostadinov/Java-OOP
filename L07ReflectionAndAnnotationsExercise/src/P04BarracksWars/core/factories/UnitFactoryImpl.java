package P04BarracksWars.core.factories;

import P04BarracksWars.interfaces.Unit;
import P04BarracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		try{
        Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
        Constructor ctor = clazz.getConstructor();
        return (Unit)ctor.newInstance();
		}catch (Exception ex){
			ex.printStackTrace();
		}

		return null;
	}
}
