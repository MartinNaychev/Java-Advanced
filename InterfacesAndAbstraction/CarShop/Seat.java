package InterfacesAndAbstraction.CarShop;

public class Seat implements Car {

    private String mode;
    private String color;
    private Integer horsePower;
    private String countryOfOrigin;

    public Seat(String mode, String color, Integer horsePower, String countryOfOrigin) {
        setMode(mode);
        setColor(color);
        setHorsePower(horsePower);
        setCountryProduced(countryOfOrigin);
    }


    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public void setCountryProduced(String countryProduced) {
        this.countryOfOrigin = countryProduced;
    }

    @Override
    public String getModel() {
        return this.mode;
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
