package ExamPreparation.exam8;

import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizeOfMatrix = Arrays
                .stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int matrixRow = sizeOfMatrix[0];
        int matrixCol = sizeOfMatrix[1];

        String[][] matrix = new String[matrixRow][matrixCol];

        int startRow = 0;
        int startCol = 0;

        int countCheese = 0;

        for (int row = 0; row < matrix.length; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                String currentSymbol = String.valueOf(line[col]);
                matrix[row][col] = currentSymbol;
                if (currentSymbol.equals("M")) {
                    startRow = row;
                    startCol = col;
                }
                if (currentSymbol.equals("C")) {
                    countCheese++;
                }
            }
        }

        String command = scanner.nextLine();
        boolean outOfBoundary = false;
        boolean mouseIsTrapped = false;

        while (!command.equals("danger") && !outOfBoundary && !mouseIsTrapped && countCheese > 0) {
            int rowBeforeMoving = startRow;
            int colBeforeMoving = startCol;
            matrix[rowBeforeMoving][colBeforeMoving] = "*";

            switch (command) {
                case "up" -> {
                    startRow--;
                    if (startRow < 0) {
                        outOfBoundary = true;
                    }
                }

                case "down" -> {
                    startRow++;
                    if (startRow > matrixRow - 1) {
                        outOfBoundary = true;
                    }
                }
                case "left" -> {
                    startCol--;
                    if (startCol < 0) {
                        outOfBoundary = true;
                    }
                }
                case "right" -> {
                    startCol++;
                    if (startCol > matrixCol - 1) {
                        outOfBoundary = true;
                    }
                }
            }
            if (outOfBoundary) {
                matrix[rowBeforeMoving][colBeforeMoving] = "M";
            } else {
                if (matrix[startRow][startCol].equals("@")) {
                    startRow = rowBeforeMoving;
                    startCol = colBeforeMoving;
                } else if (matrix[startRow][startCol].equals("T")) {

                    mouseIsTrapped = true;
                    System.out.println("Mouse is trapped!");
                } else if (matrix[startRow][startCol].equals("C")) {

                    countCheese--;

                    if (countCheese <= 0) {

                        System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    }

                }

            }

            if (!outOfBoundary) {

                matrix[startRow][startCol] = "M";
            }

            command = scanner.nextLine();
        }

        if (command.equals("danger")) {
            System.out.println("Mouse will come back later!");
        }


        if (outOfBoundary) {
            System.out.println("No more cheese for tonight!");
        }

        getPrintMatrix(matrix);

    }

    private static void getPrintMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
