package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = getMatrix(scanner);

        int[][] maxTripleMatrix = getBiggestTripleMatrix(matrix);
        
        int sum = getSum(maxTripleMatrix);
        System.out.println("Sum = " + sum);
        getPrintMatrix(maxTripleMatrix);

    }

    private static void getPrintMatrix(int[][] maxTripleMatrix) {
        for (int row = 0; row < maxTripleMatrix.length; row++) {
            for (int col = 0; col < maxTripleMatrix[row].length; col++) {
                System.out.print(maxTripleMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getBiggestTripleMatrix(int[][] matrix) {
        int[][] bufferMatrix = new int[3][3];
        int[][] biggestMatrix = new int[3][3];

        int biggestSum = Integer.MIN_VALUE;


        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int i = 0;
                int j = 0;


                for (int currentRowRotation = row; currentRowRotation < row + 3; currentRowRotation++) {
                    for (int currentColRotation = col; currentColRotation < col + 3; currentColRotation++) {
                        int element = matrix[currentRowRotation][currentColRotation];
                        bufferMatrix[i][j] = element;
                        j++;
                        if (j > 2) {
                            i++;
                            j = 0;

                        }

                    }
                }
                int sum = getSum(bufferMatrix);
                if (sum > biggestSum) {
                    biggestSum = sum;

                    for (int bufferRow = 0; bufferRow < bufferMatrix.length; bufferRow++) {
                        for (int bufferCol = 0; bufferCol < bufferMatrix[bufferRow].length; bufferCol++) {
                            biggestMatrix[bufferRow][bufferCol] = bufferMatrix[bufferRow][bufferCol];

                        }

                    }
                }
            }

        }

        return biggestMatrix;
    }

    private static int getSum(int[][] bufferMatrix) {
        int sum = 0;
        for (int row = 0; row < bufferMatrix.length; row++) {
            for (int col = 0; col < bufferMatrix[row].length; col++) {
                sum += bufferMatrix[row][col];
            }
        }
        return sum;
    }

    private static int[][] getMatrix(Scanner scanner) {
        int[] size = getArray(scanner);
        int rows = size[0];
        int cols = size[1];
        int[][] matrix = new int[rows][cols];

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
