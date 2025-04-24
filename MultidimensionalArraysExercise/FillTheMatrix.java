package MultidimensionalArraysExercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int matrixSize = Integer.parseInt(input[0]);
        String type = input[1];
        int[][] matrix = new int[matrixSize][matrixSize];


        if (type.equals("A")) {
            matrix = getMatrixA(matrixSize);

        } else if (type.equals("B")) {
            matrix = getMatrixB(matrixSize);
        }
        getPrintMatrix(matrix);
    }

    private static int[][] getMatrixB(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];
        int number = 1;
        int row = 0;
        for (int col = 0; col < matrixSize; col++) {
            if (row == 0) {
                while (row < matrixSize) {
                    matrix[row][col] = number;
                    row++;
                    number++;
                }

            } else if (row == matrixSize) {
                row--;
                while (row >= 0) {
                    matrix[row][col] = number;
                    row--;
                    number++;
                }
                row = 0;
            }

        }

        return matrix;
    }

    private static void getPrintMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

        }

    }

    private static int[][] getMatrixA(int matrixSize) {

        int[][] matrix = new int[matrixSize][matrixSize];

        int numbers = 1;
        for (int col = 0; col < matrixSize; col++) {
            for (int row = 0; row < matrixSize; row++) {
                matrix[row][col] = numbers;
                numbers++;
            }
        }
        return matrix;
    }
}
