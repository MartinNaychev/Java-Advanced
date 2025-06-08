package DefiningClassesExercise.CarSalesman;

public class Car {
    private String model;
    private String engine;
    private int wight;
    private String color;

    public Car(String model, String engine, int wight, String color) {
        this.model = model;
        this.engine = engine;
        this.wight = wight;
        this.color = color;
    }

    public Car(String model, String engine) {
        this.model = model;
        this.engine = engine;
        this.wight = 0;
        this.color = "n/a";
    }

    public Car(String model, String engine, int wight) {
        this.model = model;
        this.engine = engine;
        this.wight = wight;
        this.color = "n/a";
    }

    public Car(String model, String engine, String color) {
        this.model = model;
        this.engine = engine;
        this.wight = 0;
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public String getModel() {
        return model;

    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        if (this.wight==0){
            stringBuilder.append("Weight: n/a" + "\n");
        }else {
            stringBuilder.append("Weight: " + this.wight + "\n");
        }
        stringBuilder.append("Color: "+ this.color);

        return stringBuilder.toString();

    }
}
