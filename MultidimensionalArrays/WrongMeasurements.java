package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = getMatrix(scanner);

        int[] index = getArray(scanner);
        int rowIndex = index[0];
        int colIndex = index[1];
        int lookingFor = matrix[rowIndex][colIndex];
        List<int[]> newValue = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentIndex = matrix[row][col];
                int sum = 0;

                if (currentIndex == lookingFor) {
                    if (isBound(matrix, row - 1, col) && matrix[row - 1][col] != lookingFor) {
                        sum += matrix[row - 1][col];
                    }
                    if (isBound(matrix, row + 1, col) && matrix[row + 1][col] != lookingFor) {
                        sum += matrix[row + 1][col];
                    }
                    if (isBound(matrix, row, col - 1) && matrix[row][col - 1] != lookingFor) {
                        sum += matrix[row][col - 1];

                    }
                    if (isBound(matrix, row, col + 1) && matrix[row][col + 1] != lookingFor) {
                        sum += matrix[row][col + 1];
                    }
                    int[] forReplace = new int[3];
                    forReplace[0] = row;
                    forReplace[1] = col;
                    forReplace[2] = sum;
                    newValue.add(forReplace);

                }

            }
        }
        for (int[] rows : newValue) {
            matrix[rows[0]][rows[1]] = rows[2];
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();

        }

    }


    private static boolean isBound(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[][] getMatrix(Scanner scanner) {
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][];
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
