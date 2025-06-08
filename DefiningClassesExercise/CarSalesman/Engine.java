package DefiningClassesExercise.CarSalesman;

public class Engine {
    private String engineModel;
    private int enginPower;
    private int enginDisplacement;
    private String enginEfficiency;

    public Engine(String engineModel, int enginPower, int enginDisplacement, String enginEfficiency) {
        this.engineModel = engineModel;
        this.enginPower = enginPower;
        this.enginDisplacement = enginDisplacement;
        this.enginEfficiency = enginEfficiency;
    }

    public Engine(String engineModel, int enginPower) {
        this.engineModel = engineModel;
        this.enginPower = enginPower;
        this.enginDisplacement = 0;
        this.enginEfficiency = "n/a";
    }

    public Engine(String engineModel, int enginPower, int enginDisplacement) {
        this.engineModel = engineModel;
        this.enginPower = enginPower;
        this.enginDisplacement = enginDisplacement;
        this.enginEfficiency = "n/a";
    }

    public Engine(String engineModel, int enginPower, String enginEfficiency) {
        this.engineModel = engineModel;
        this.enginPower = enginPower;
        this.enginDisplacement = 0;
        this.enginEfficiency = enginEfficiency;

    }

    public String getEngineModel() {
        return this.engineModel;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Power: " + this.enginPower + "\n");
        if (enginDisplacement == 0) {
            stringBuilder.append("Displacement: n/a" + "\n");
        } else {
            stringBuilder.append("Displacement: " + this.enginDisplacement + "\n");
        }
        stringBuilder.append("Efficiency: " + this.enginEfficiency);
        return stringBuilder.toString();
    }
}
