package ReflectionAndAnnotationsExercise.barracksWars.core.commands;

import ReflectionAndAnnotationsExercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationsExercise.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command{
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {

        String unitType = getData()[1];

        String message = unitType + "retired!";

        try{
            this.getRepository().removeUnit(unitType);

        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
        return message;
    }
}
