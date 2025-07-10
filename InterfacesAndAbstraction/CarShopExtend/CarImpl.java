package InterfacesAndAbstraction.CarShopExtend;

public class CarImpl implements Car{
    private String model;
    private String color;
    private Integer horsePower;
    private String countryOfOrigin;

    public CarImpl(String model, String color, Integer horsePower, String countryOfOrigin) {
        setModel(model);
        setColor(color);
        setHorsePower(horsePower);
        setCountryOfOrigin(countryOfOrigin);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.countryOfOrigin;
    }

    @Override
    public String toString() {
         return String.format("This is %s produced in %s and have 4 tires",this.getModel(),this.countryProduced());
    }
}
