package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = getMatrix(scanner);

        String[] input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("END")) {

            if (input[0].equals("swap") && input.length == 5) {

                int firstRow = Integer.parseInt(input[1]);
                int firstCol = Integer.parseInt(input[2]);
                int secondRow = Integer.parseInt(input[3]);
                int secondCol = Integer.parseInt(input[4]);
                if (firstRow >= 0 && firstRow < matrix.length &&
                        secondRow >= 0 && secondRow < matrix.length &&
                        firstCol >= 0 && firstCol < matrix[firstRow].length &&
                        secondCol >= 0 && secondCol < matrix[secondRow].length) {

                    String firstPosition = matrix[firstRow][firstCol];
                    String secondPosition = matrix[secondRow][secondCol];
                    matrix[firstRow][firstCol] = secondPosition;
                    matrix[secondRow][secondCol] = firstPosition;

                    for (String[] rows : matrix) {
                        for (String cols : rows) {
                            System.out.print(cols + " ");
                        }
                        System.out.println();
                    }
                }else {
                    System.out.println("Invalid input!");
                }


            } else {
                System.out.println("Invalid input!");
            }


            input = scanner.nextLine().split("\\s+");
        }


    }

    private static String[][] getMatrix(Scanner scanner) {
        int[] size = getArray(scanner);
        int rows = size[0];
        int cols = size[1];
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");

        }
        return matrix;
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
