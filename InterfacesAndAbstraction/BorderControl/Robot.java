package InterfacesAndAbstraction.BorderControl;

public class Robot implements Identifiable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        setModel(model);
        setId(id);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }
}
