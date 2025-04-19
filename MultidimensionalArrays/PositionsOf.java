package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = getMatrix(scanner);
        int lookingFor = Integer.parseInt(scanner.nextLine());
        boolean isFount = false;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == lookingFor) {
                    System.out.println(r + " " + c);
                    isFount = true;
                }

            }

        }
        if (!isFount){
            System.out.println("not found");
        }

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
