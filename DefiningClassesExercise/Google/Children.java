package DefiningClassesExercise.Google;

public class Children {
    private String name;
    private String birthday;

    public Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString(){
        return this.name + " " + this.birthday;
    }
}
