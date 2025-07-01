package EncapsulationExercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.money = money;
        }
    }

    public String getName() {
        return name;
    }

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products=new ArrayList<>();
    }

    public void buyProduct (Product product){
        if (money>=product.getCost()){
            products.add(product);
        }else {
            throw new IllegalArgumentException(String.format("%s can't afford %s",name,product.getName()));
        }


    }


}
