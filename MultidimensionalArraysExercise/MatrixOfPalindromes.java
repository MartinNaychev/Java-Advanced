package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = getMatrix(scanner);
        printMatrix(matrix);

    }
    private static String[][] getMatrix(Scanner scanner) {
        int[] size = getArray(scanner);
        int rows = size[0];
        int cols = size[1];

        char symbolsA = 97;
        char symbolsB = 97;
        char symbolsC = 97;

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                StringBuilder value = new StringBuilder("" + symbolsA + symbolsB + symbolsC);
                matrix[row][col] = String.valueOf(value);
                symbolsB++;

            }
            symbolsA++;
            symbolsB=symbolsA;
            symbolsC++;
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

        }
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
