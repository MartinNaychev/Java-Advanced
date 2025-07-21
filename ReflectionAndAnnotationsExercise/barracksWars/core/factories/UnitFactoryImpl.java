package ReflectionAndAnnotationsExercise.barracksWars.core.factories;

import ReflectionAndAnnotationsExercise.barracksWars.interfaces.Unit;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "ReflectionAndAnnotationsExercise.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {

        Unit newUnit = null;
        try {
            Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> unitConstructor = unitClass.getConstructor();
			newUnit = unitConstructor.newInstance();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
        } catch (NoSuchMethodException e) {
			e.printStackTrace();
        } catch (InvocationTargetException e) {
			e.printStackTrace();
        } catch (InstantiationException e) {
			e.printStackTrace();
        } catch (IllegalAccessException e) {
			e.printStackTrace();
        }


        return newUnit;
    }
}
