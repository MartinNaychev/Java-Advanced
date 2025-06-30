package WorkingWithAbstractionExercise.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = fillTheMatrix(scanner);

        String coordinates = scanner.nextLine();

        long collectedPower = 0;

        while (!coordinates.equals("Let the Force be with you")) {
            int[] jediCoordinates = readCoordinates(coordinates);
            int[] evilCoordinates = readArray(scanner);

            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];
            int jediRow = jediCoordinates[0];
            int jediCol = jediCoordinates[1];


            while (evilRow >= 0 && evilCol >= 0) {
                if (evilRow < matrix.length && evilCol < matrix[0].length) {
                    matrix[evilRow][evilCol] = 0;
                }
                evilRow--;
                evilCol--;
            }



            while (jediRow >= 0 && jediCol < matrix[1].length) {
                if (jediRow < matrix.length && jediCol >= 0 && jediCol < matrix[0].length) {
                    collectedPower += matrix[jediRow][jediCol];
                }
                jediRow--;
                jediCol++;

            }

            coordinates = scanner.nextLine();
        }

        System.out.println(collectedPower);


    }

    private static int[] readCoordinates(String coordinates) {
        return Arrays.stream(coordinates.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] fillTheMatrix(Scanner scanner) {
        int[] matrixSize = readArray(scanner);
        int rows = matrixSize[0];
        int cols = matrixSize[1];

        int[][] matrix = new int[rows][cols];

        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = counter++;
            }
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
