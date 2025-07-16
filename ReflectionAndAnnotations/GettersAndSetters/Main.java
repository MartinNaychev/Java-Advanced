package ReflectionAndAnnotations.GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class reflection = Reflection.class;

        Method[] methods = reflection.getDeclaredMethods();
        Arrays.sort(methods, (m1, m2) -> m1.getName().compareTo(m2.getName()));


        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get"))
                .forEach(method -> System.out.println(method.getName() + " will return class "  + method.getReturnType().getSimpleName()));

        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set"))
                .forEach(method -> System.out.println(method.getName() + " and will set field of class "  + method.getParameterTypes()[0].getSimpleName()));

    }
}
