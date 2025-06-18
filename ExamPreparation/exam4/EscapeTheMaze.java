package ExamPreparation.exam4;

import java.util.Scanner;

public class EscapeTheMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];

        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < sizeOfMatrix; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < sizeOfMatrix; col++) {
                String currentSymbol = String.valueOf(line[col]);
                matrix[row][col] = currentSymbol;
                if (currentSymbol.equals("P")) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        int health = 100;

        while (true) {
            String command = scanner.nextLine();

            matrix[startRow][startCol] = "-";
            switch (command) {
                case "up" -> {
                    if (startRow == 0) {
                    } else {
                        startRow--;
                    }
                }
                case "down" -> {
                    if (startRow >= sizeOfMatrix - 1) {
                    } else {
                        startRow++;
                    }
                }
                case "left" -> {
                    if (startCol == 0) {
                    } else {
                        startCol--;
                    }
                }
                case "right" -> {
                    if (startCol >= sizeOfMatrix - 1) {
                    } else {
                        startCol++;
                    }
                }
            }


            if (matrix[startRow][startCol].equals("M")) {
                health -= 40;
                if (health <= 0) {
                    matrix[startRow][startCol] = "P";
                    health=0;
                    System.out.println("Player is dead. Maze over!");
                    System.out.printf("Player's health: %d units%n",health);
                    getPrintMatrix(matrix);
                    break;
                }
            }
            if (matrix[startRow][startCol].equals("H")) {
                health+=15;
                if (health>100){
                    health=100;
                }

            }

            if (matrix[startRow][startCol].equals("X")) {
                matrix[startRow][startCol] = "P";
                System.out.println("Player escaped the maze. Danger passed!");
                System.out.printf("Player's health: %d units%n",health);
                getPrintMatrix(matrix);
                break;

            }
            matrix[startRow][startCol] = "P";
        }


    }
    private static void getPrintMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
