package Polymorphism.Animal;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    protected Animal(String name, String favoriteFood) {
        setName(name);
        setFavouriteFood(favoriteFood);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public String getName() {
        return this.name;
    }

    public String getFavouriteFood() {
        return this.favouriteFood;
    }

    public abstract String explainSelf();
}
