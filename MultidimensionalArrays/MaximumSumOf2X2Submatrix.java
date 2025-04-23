package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = getMatrix(scanner);
        int biggestSum = Integer.MIN_VALUE;
        int[][] biggestMatrix = new int[2][2];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int topLeft = matrix[row][col];
                int topRight = matrix[row][col + 1];
                int downLeft = matrix[row + 1][col];
                int dowRight = matrix[row + 1][col + 1];

                int sum = topLeft + topRight + downLeft + dowRight;

                if (sum > biggestSum) {
                    biggestSum = sum;
                    biggestMatrix[0][0] = topLeft;
                    biggestMatrix[0][1] = topRight;
                    biggestMatrix[1][0] = downLeft;
                    biggestMatrix[1][1] = dowRight;
                }
            }
        }

        for (int row = 0; row < biggestMatrix.length; row++) {
            for (int col = 0; col < biggestMatrix[row].length; col++) {
                System.out.print(biggestMatrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(biggestSum);

    }

    private static int[][] getMatrix(Scanner scanner) {
        int[] input = getArray(scanner);
        int rows = input[0];
        int cols = input[1];
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
