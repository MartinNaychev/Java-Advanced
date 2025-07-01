package EncapsulationExercise.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    private void setFlourType(String flourType) {
        switch (flourType) {
            case "White", "Wholegrain" -> this.flourType = flourType;
            default -> throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy", "Chewy", "Homemade" -> this.bakingTechnique = bakingTechnique;
            default -> throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        } else {
            this.weight = weight;
        }
    }

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public double calculateCalories() {
        double flourCalories = 0.00;
        double bakingCalories = 0.00;
        switch (flourType) {
            case "White" -> flourCalories = 1.5;
            case "Wholegrain" -> flourCalories = 1.0;
        }
        switch (bakingTechnique) {
            case "Crispy" -> bakingCalories = 0.9;
            case "Chewy" -> bakingCalories = 1.1;
            case "Homemade" -> bakingCalories = 1.0;
        }
        return (2 * weight) * flourCalories * bakingCalories;

    }
}
