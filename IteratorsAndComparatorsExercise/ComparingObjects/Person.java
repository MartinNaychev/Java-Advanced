package IteratorsAndComparatorsExercise.ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private Integer age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person newPerson) {
        int nameResult = this.name.compareTo(newPerson.name);
        int ageResult = this.age.compareTo(newPerson.age);
        int townResult = this.town.compareTo(newPerson.town);

        if (nameResult != 0) {
            return nameResult;

        } else if (ageResult != 0) {
            return townResult;
        } else {
            return townResult;
        }


    }
}
