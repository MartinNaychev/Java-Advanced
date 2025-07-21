package ReflectionAndAnnotationsExercise.barracksWars;

import ReflectionAndAnnotationsExercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotationsExercise.barracksWars.core.Engine;
import ReflectionAndAnnotationsExercise.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotationsExercise.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
