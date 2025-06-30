package WorkingWithAbstractionExercise.TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class MainSecond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lights[] lights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(light -> Lights.valueOf(light))
                .toArray(Lights[]::new);

        int cycle = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cycle; i++) {
            updateLight(lights);
            printLights(lights);

        }
    }

    private static void printLights(Lights[] lights) {
        Arrays.stream(lights).forEach(light -> System.out.print(light + " "));
        System.out.println();
    }

    private static void updateLight(Lights[] lights) {
        for (int i = 0; i < lights.length; i++) {
            switch (lights[i]){
                case RED -> lights[i] = Lights.GREEN;
                case GREEN -> lights[i] = Lights.YELLOW;
                case YELLOW -> lights[i] = Lights.RED;
            }

        }
    }
}
