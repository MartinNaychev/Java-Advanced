package WorkingWithAbstractionExercise.TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lightsInput = scanner.nextLine().split("\\s+");

        int cycle = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cycle; i++) {


            for (int j = 0; j < lightsInput.length; j++) {
                String light = lightsInput[j];
                String nextLight = getNextLight(light);
                lightsInput[j]=nextLight;
                System.out.print(lightsInput[j] + " ");

            }



            System.out.println();

        }
    }

    private static String getNextLight(String light) {

        switch (light) {
            case "RED" -> light =String.valueOf( Lights.GREEN);
            case "GREEN" -> light =String.valueOf( Lights.YELLOW);
            case "YELLOW" -> light =String.valueOf( Lights.RED);
        }
        return light;
    }
}
