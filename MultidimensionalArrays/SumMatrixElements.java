package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = getArray(scanner);
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = getMatrix(rows, cols, scanner);
        int totalSum = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentPosition = matrix[row][col];
                totalSum += currentPosition;

            }

        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(totalSum);

    }

    private static int[][] getMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = getArray(scanner);

        }

        return matrix;
    }


    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
