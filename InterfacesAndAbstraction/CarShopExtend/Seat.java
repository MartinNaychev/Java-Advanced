package InterfacesAndAbstraction.CarShopExtend;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryOfOrigin, Double price) {
        super(model, color, horsePower, countryOfOrigin);
        this.price = price;
    }



        @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("This is %s produced in %s and have 4 tires",super.getModel(),super.countryProduced())).append(System.lineSeparator());
        builder.append(String.format("%s sells for %f", super.getModel(), this.price));

        return builder.toString();
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
