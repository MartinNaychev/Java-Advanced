package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = getMatrix(scanner);

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");

        }

        System.out.println();
        int counter = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            System.out.print(matrix[i][counter] + " ");
            counter++;
        }


    }

    private static int[][] getMatrix(Scanner scanner) {
        int input = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[input][input];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }
}
