package InterfacesAndAbstraction.CarShopExtend;

public class Audi extends CarImpl implements Rentable{
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryOfOrigin, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryOfOrigin);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("This is %s produced in %s and have 4 tires",super.getModel(),super.countryProduced())).append(System.lineSeparator());
        builder.append(String.format("Minimum rental period of %d days. Price per day %f", this.getMinRentDay(), this.getPricePerDay()));

        return builder.toString();
    }
}
