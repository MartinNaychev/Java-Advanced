package EncapsulationExercise.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat", "Veggies", "Cheese", "Sauce" -> this.toppingType = toppingType;
            default ->
                    throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }

    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public double calculateCalories() {
        double calories = 0.00;
        switch (toppingType) {
            case "Meat" -> calories = 1.2;
            case "Veggies" -> calories = 0.8;
            case "Cheese" -> calories = 1.1;
            case "Sauce" -> calories = 0.9;

        }
        return 2*weight*calories;
    }
}
