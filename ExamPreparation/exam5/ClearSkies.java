package ExamPreparation.exam5;

import java.util.Scanner;

public class ClearSkies {
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
                if (currentSymbol.equals("J")) {
                    startRow = row;
                    startCol = col;
                }
            }
        }


        int armor = 300;
        int enemy = 4;

        while (true) {

            String command = scanner.nextLine();
            matrix[startRow][startCol] = "-";

            switch (command) {
                case "up" -> startRow--;
                case "down" -> startRow++;
                case "left" -> startCol--;
                case "right" -> startCol++;
            }
            if (matrix[startRow][startCol].equals("R")) {
                armor += 100;
                if (armor > 300) {
                    armor = 300;
                }
            }
            if (matrix[startRow][startCol].equals("E")) {
                if (enemy == 1) {

                    matrix[startRow][startCol] = "J";
                    System.out.println("Mission accomplished, you neutralized the aerial threat!");
                    getPrintMatrix(matrix);
                    break;
                }else {
                    enemy--;
                    armor-=100;

                    if (armor<=0){
                        matrix[startRow][startCol] = "J";
                        System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n",startRow,startCol);
                        getPrintMatrix(matrix);
                        break;
                    }

                }
            }

            matrix[startRow][startCol] = "J";

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
