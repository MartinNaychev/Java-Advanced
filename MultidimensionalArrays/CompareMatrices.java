package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = getMatrix(scanner);
        int[][] secondMatrix = getMatrix(scanner);

        boolean areEquals = firstMatrix.length == secondMatrix.length;

        int i = 0;
        while (i < firstMatrix.length && areEquals) {
            int[] firstArr = firstMatrix[i];
            int[] secondArr = secondMatrix[i];
            areEquals = firstArr.length == secondArr.length;

            int j = 0;
            while (j < firstArr.length && areEquals) {
                areEquals = firstArr[j] == secondArr[j];
                j++;
            }
            i++;
        }

        String output = areEquals ? "equal" : "not equal";
        System.out.println(output);


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
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
