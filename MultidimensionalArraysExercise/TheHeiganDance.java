package MultidimensionalArraysExercise;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playerHealth = 18500;
        double heiganHealth = 3000000.00;

        int startRow = 7;
        int startCol = 7;

        boolean activeCloud = false;
        String lastSpell = "";
        double damage = Double.parseDouble(scanner.nextLine());


        while (playerHealth > 0 && heiganHealth > 0) {

            heiganHealth -= damage;

            if (activeCloud) {
                playerHealth -= 3500;
                activeCloud = false;
                if (playerHealth <= 0) {
                    break;
                }
            }

            if (heiganHealth <= 0) {
                break;
            }


            String[] spellsParts = scanner.nextLine().split("\\s+");

            String spell = spellsParts[0];
            int spellRow = Integer.parseInt(spellsParts[1]);
            int spellCol = Integer.parseInt(spellsParts[2]);

            boolean[][] chamber = new boolean[15][15];

            for (int i = spellRow - 1; i <= spellRow + 1; i++) {
                if (i >= 0 && i < chamber.length) {
                    for (int j = spellCol - 1; j <= spellCol + 1; j++) {
                        if (j >= 0 && j < chamber.length) {
                            chamber[i][j] = true;
                        }
                    }
                }
            }

            if (chamber[startRow][startCol]) {
                if (isValidRow(chamber, startRow - 1) && !chamber[startRow - 1][startCol]) {
                    startRow--;
                } else if (isValidCol(chamber, startCol + 1) && !chamber[startRow][startCol + 1]) {
                    startCol++;
                } else if (isValidRow(chamber, startRow + 1) && !chamber[startRow + 1][startCol]) {
                    startRow++;
                } else if (isValidCol(chamber, startCol - 1) && !chamber[startRow][startCol - 1]) {
                    startCol--;
                }

                if (chamber[startRow][startCol]) {

                    switch (spell) {
                        case "Cloud": {
                            playerHealth -= 3500;
                            activeCloud = true;
                            lastSpell = "Plague Cloud";
                            break;

                        }
                        case "Eruption": {
                            playerHealth -= 6000;
                            lastSpell = "Eruption";
                            break;
                        }
                        default:
                            throw new IllegalArgumentException("Invalid spell: " + spell);
                    }
                }
            }
        }

        if (heiganHealth > 0) {
            System.out.printf("Heigan: %.2f%n", heiganHealth);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHealth > 0) {
            System.out.printf("Player: %d%n", playerHealth);
        } else {
            System.out.printf("Player: Killed by %s%n", lastSpell);
        }
        System.out.printf("Final position: %d, %d", startRow, startCol);


    }

    private static boolean isValidRow(boolean[][] chamber, int startRow) {
        return startRow >= 0 && startRow < chamber.length;
    }

    private static boolean isValidCol(boolean[][] chamber, int startCol) {
        return startCol >= 0 && startCol < chamber.length;
    }
}
