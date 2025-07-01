package EncapsulationExercise.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numbersOfToppings) {
        if (numbersOfToppings<0 || numbersOfToppings>10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }else {
            this.toppings = new ArrayList<>(numbersOfToppings);
        }
    }

    public Pizza(String name,int numbersOfToppings) {
       setName(name);
       setToppings(numbersOfToppings);
    }

    public String getName() {
        return name;
    }
    public void addTopping (Topping topping){
        this.toppings.add(topping);

    }
    public double getOverallCalories (){
return this.dough.calculateCalories()+this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }
}
