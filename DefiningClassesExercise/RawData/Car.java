package DefiningClassesExercise.RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engines;
    private Cargo cargos;
    private List<Tire> tires;

    public Car(String model, Engine engines, Cargo cargos, List<Tire> tires) {
        this.model = model;
        this.engines = engines;
        this.cargos = cargos;
        this.tires = tires;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngines() {
        return this.engines;
    }

    public void setEngines(Engine engines) {
        this.engines = engines;
    }

    public Cargo getCargos() {
        return this.cargos;
    }

    public void setCargos(Cargo cargos) {
        this.cargos = cargos;
    }

    public List<Tire> getTires() {
        return this.tires;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }
}
