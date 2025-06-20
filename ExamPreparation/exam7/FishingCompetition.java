package ExamPreparation.exam7;

import java.util.Scanner;

public class FishingCompetition {
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
                if (currentSymbol.equals("S")) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        int collectedFIsh = 0;
        boolean fellIntoAWhirlpool = false;

        String command = scanner.nextLine();

        while (!command.equals("collect the nets") && !fellIntoAWhirlpool) {
            matrix[startRow][startCol] = "-";

            switch (command) {
                case "up" -> {
                    startRow--;
                    if (startRow < 0) {
                        startRow = sizeOfMatrix - 1;
                    }
                }
                case "down" -> {
                    startRow++;
                    if (startRow > sizeOfMatrix - 1) {
                        startRow = 0;
                    }
                }
                case "left" -> {
                    startCol--;
                    if (startCol < 0) {
                        startCol = sizeOfMatrix - 1;
                    }
                }
                case "right" -> {
                    startCol++;
                    if (startCol > sizeOfMatrix - 1) {
                        startCol = 0;
                    }
                }
            }
            if (Character.isDigit(matrix[startRow][startCol].charAt(0))) {
                collectedFIsh += Integer.parseInt(matrix[startRow][startCol]);
            } else if (matrix[startRow][startCol].equals("W")) {
                collectedFIsh = 0;
                fellIntoAWhirlpool = true;
            }

            matrix[startRow][startCol] = "S";
            command = scanner.nextLine();
        }



        if (fellIntoAWhirlpool){
            System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]%n",startRow,startCol);
        } else if (collectedFIsh>=20) {
            System.out.println("Success! You managed to reach the quota!");
            System.out.printf("Amount of fish caught: %d tons.%n",collectedFIsh);
            getPrintMatrix(matrix);
        } else if (collectedFIsh<20) {
            System.out.print("You didn't catch enough fish and didn't reach the quota! ");
            System.out.printf("You need %d tons of fish more.%n",20-collectedFIsh);
            if (collectedFIsh > 0) {
            System.out.printf("Amount of fish caught: %d tons.%n",collectedFIsh);
            }
            getPrintMatrix(matrix);
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
