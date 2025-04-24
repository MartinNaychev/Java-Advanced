package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = getMatrix(scanner, size);

        int rightDiagonal = 0;
        int leftDiagonal = 0;
        int i = 0;
        while (i < matrix.length) {
            rightDiagonal += matrix[i][i];
            leftDiagonal += matrix[i][size - 1 - i];
            i++;
        }
        System.out.println(Math.abs(rightDiagonal-leftDiagonal));

    }

    private static int[][] getMatrix(Scanner scanner, int size) {

        int[][] matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = getArray(scanner);

        }

        return matrix;
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
