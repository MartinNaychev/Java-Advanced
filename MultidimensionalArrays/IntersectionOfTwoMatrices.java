package MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] matrixA = readMatrix(scanner, rows, cols);
        String[][] matrixB = readMatrix(scanner, rows, cols);

        String[][] matrixC = fillTheMatrix(rows, cols, matrixA, matrixB);

        for (int row = 0; row < matrixC.length; row++) {
            for (int col = 0; col < matrixC[row].length; col++) {
                System.out.print(matrixC[row][col] + " ");
            }
            System.out.println();

        }

    }

    private static String[][] fillTheMatrix(int rows, int cols, String[][] matrixA, String[][] matrixB) {

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String elementA = matrixA[row][col];
                String elementB = matrixB[row][col];
                if (elementA.equals(elementB)) {
                    matrix[row][col] = elementA;

                } else {
                    matrix[row][col] = "*";
                }
            }

        }


        return matrix;
    }

    private static String[][] readMatrix(Scanner scanner, int rows, int cols) {

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArr(scanner);
        }
        return matrix;
    }

    private static String[] readArr(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
