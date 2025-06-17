package ExamPreparation.exam3;

import java.util.Collections;
import java.util.Scanner;

public class Beesy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeofMatrix = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[sizeofMatrix][sizeofMatrix];

        int beeRow = 0;
        int beeCol = 0;
        int hiveRow = 0;
        int hiveCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                String currentSymbol = String.valueOf(line[col]);
                matrix[row][col] = currentSymbol;


                if (currentSymbol.equals("B")) {
                    beeRow = row;
                    beeCol = col;
                }
                if (currentSymbol.equals("H")) {
                    hiveRow = row;
                    hiveCol = col;
                }

            }
        }

        int beeEnergy = 15;
        int collectedNectar = 0;
        boolean reachesTheHive = false;
        int resurrectCounter = 1;

        while (beeEnergy > 0 && !reachesTheHive) {
            beeEnergy--;
            matrix[beeRow][beeCol] = "-";
            String command = scanner.nextLine();

            boolean inMatrixRange = validateMove(command, matrix, beeRow, beeCol);


            switch (command) {
                case "up" -> {
                    if (inMatrixRange) {
                        beeRow--;
                    } else {
                        beeRow = matrix.length - 1;
                    }
                }
                case "down" -> {
                    if (inMatrixRange) {
                        beeRow++;
                    } else {
                        beeRow = 0;
                    }
                }
                case "left" -> {
                    if (inMatrixRange) {
                        beeCol--;
                    } else {
                        beeCol = matrix.length - 1;
                    }
                }
                case "right" -> {
                    if (inMatrixRange) {
                        beeCol++;
                    } else {
                        beeCol = 0;
                    }
                }
            }

            if (isNumeric(matrix[beeRow][beeCol])) {
                collectedNectar += Integer.parseInt(matrix[beeRow][beeCol]);
            }

            if (beeRow == hiveRow && beeCol == hiveCol) {
                reachesTheHive = true;
            }


            if (beeEnergy <= 0 && collectedNectar > 30 && resurrectCounter == 1 && !reachesTheHive) {
                resurrectCounter--;
                beeEnergy = collectedNectar - 30;
                //beeEnergy += (collectedNectar - 30);
                collectedNectar = 30;
            }


            matrix[beeRow][beeCol] = "B";
        }


        if (reachesTheHive && collectedNectar >= 30) {
            System.out.printf("Great job, Beesy! The hive is full. Energy left: %d%n", beeEnergy);
        } else if (reachesTheHive) {
            System.out.println("Beesy did not manage to collect enough nectar.");
        }

        if (!reachesTheHive && beeEnergy == 0) {
            System.out.println("This is the end! Beesy ran out of energy.");
        }


        getPrintMatrix(matrix);

    }

    private static boolean isNumeric(String position) {
        try {
            Integer.parseInt(position);
            return true;
        } catch (NumberFormatException e) {
            return false;
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

    private static boolean validateMove(String command, String[][] matrix, int beeRow, int beeCol) {
        switch (command) {
            case "up" -> {
                if (beeRow > 0) {
                    return true;
                }
            }
            case "down" -> {
                if (beeRow < matrix.length - 1){
                    return true;
                }

            }
            case "left" -> {
                if (beeCol > 0) {
                    return true;
                }
            }
            case "right" -> {
                if (beeCol < matrix.length - 1) {
                    return true;
                }

            }

        }
        return false;
    }
}
