package ExamPreparation.exam6;

import java.util.Scanner;

public class TheGambler {
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
                if (currentSymbol.equals("G")) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        int money = 100;
        boolean reachTheJackpot = false;


        String command = scanner.nextLine();
        while (!command.equals("end") && money > 0 && !reachTheJackpot) {
            matrix[startRow][startCol] = "-";

            switch (command) {
                case "up" -> {
                    startRow--;
                    if (startRow < 0) {
                        money = -1;
                    }
                }
                case "down" -> {
                    startRow++;
                    if (startRow > sizeOfMatrix - 1) {
                        money = -1;
                    }
                }
                case "left" -> {
                    startCol--;
                    if (startRow < 0) {
                        money = -1;
                    }
                }
                case "right" -> {
                    startCol++;
                    if (startCol > sizeOfMatrix - 1) {
                        money = -1;
                    }
                }
            }

            if (matrix[startRow][startCol].equals("W")) {
                money += 100;
            } else if (matrix[startRow][startCol].equals("P")) {
                money -= 200;

            } else if (matrix[startRow][startCol].equals("J")) {
                money += 100000;
                reachTheJackpot = true;
            }


            matrix[startRow][startCol] = "G";
            command = scanner.nextLine();
        }



        if (reachTheJackpot){
            System.out.println("You win the Jackpot!");
            System.out.printf("End of the game. Total amount: %d$%n",money);
            getPrintMatrix(matrix);
        } else if (money<=0) {
            System.out.println("Game over! You lost everything!");

        }else {
            System.out.printf("End of the game. Total amount: %d$%n",money);
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
