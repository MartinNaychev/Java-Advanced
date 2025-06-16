package ExamPreparation.exam2;

import java.util.Arrays;
import java.util.Scanner;

public class BombHasBeenPlanted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixSize = getArray(scanner);

        int rows = matrixSize[0];
        int cols = matrixSize[1];

        String[][] matrix = new String[rows][cols];


        int bombRowPosition = 0;
        int bombColPosition = 0;

        int rowPosition = 0;
        int colPosition = 0;


        for (int row = 0; row < matrix.length; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                String currentSymbol = String.valueOf(line[col]);
                matrix[row][col] = currentSymbol;

                if (currentSymbol.equals("C")) {

                    rowPosition = row;
                    colPosition = col;
                }
                if (currentSymbol.equals("B")) {
                    bombRowPosition = row;
                    bombColPosition = col;

                }

            }

        }

        int clock = 16;


        boolean youAreKilled = false;
        boolean bombIsDefuse = false;
        boolean bombExplode = false;
        String lastCommand = "";

        while (!youAreKilled && !bombIsDefuse && !bombExplode) {

            String command = scanner.nextLine();
            lastCommand = command;
            switch (command) {
                case "up" -> {
                    clock--;
                    if (rowPosition == 0) {
                    } else {
                        rowPosition--;
                        if (matrix[rowPosition][colPosition].equals("T")) {
                            matrix[rowPosition][colPosition] = "*";
                            youAreKilled = true;

                        } else if (matrix[rowPosition][colPosition].equals("B")) {
                            bombRowPosition = rowPosition;
                            bombColPosition = colPosition;
                        }
                    }

                }
                case "down" -> {
                    clock--;

                    if (rowPosition >= rows - 1) {
                    } else {
                        rowPosition++;
                        if (matrix[rowPosition][colPosition].equals("T")) {
                            matrix[rowPosition][colPosition] = "*";
                            youAreKilled = true;

                        } else if (matrix[rowPosition][colPosition].equals("B")) {
                            bombRowPosition = rowPosition;
                            bombColPosition = colPosition;
                        }

                    }

                }
                case "left" -> {
                    clock--;
                    if (colPosition == 0) {
                    } else {
                        colPosition--;
                        if (matrix[rowPosition][colPosition].equals("T")) {
                            matrix[rowPosition][colPosition] = "*";
                            youAreKilled = true;

                        } else if (matrix[rowPosition][colPosition].equals("B")) {
                            bombRowPosition = rowPosition;
                            bombColPosition = colPosition;
                        }
                    }

                }
                case "right" -> {
                    clock--;
                    if (colPosition >= cols - 1) {
                    } else {
                        colPosition++;
                        if (matrix[rowPosition][colPosition].equals("T")) {
                            matrix[rowPosition][colPosition] = "*";
                            youAreKilled = true;

                        } else if (matrix[rowPosition][colPosition].equals("B")) {
                            bombRowPosition = rowPosition;
                            bombColPosition = colPosition;
                        }
                    }

                }
                case "defuse" -> {
                    if (bombRowPosition == rowPosition && bombColPosition == colPosition && clock >= 4) {
                        clock -= 4;
                        matrix[rowPosition][colPosition] = "D";
                        bombIsDefuse = true;
                    } else if (bombRowPosition != rowPosition || bombColPosition != colPosition) {
                        clock -= 2;

                    } else if (bombRowPosition == rowPosition && bombColPosition == colPosition && clock < 4) {
                        clock -= 4;
                        matrix[rowPosition][colPosition] = "X";
                        bombExplode = true;


                    }

                }
            }


            if (clock <= 0) {
                bombExplode = true;
            }

        }

        if (youAreKilled) {
            System.out.println("Terrorists win!");
        } else {
            if (bombIsDefuse) {
                System.out.println("Counter-terrorist wins!");
                System.out.printf("Bomb has been defused: %d second/s remaining.%n", clock);
            } else {
                System.out.println("Terrorists win!");
                System.out.println("Bomb was not defused successfully!");
                System.out.printf("Time needed: %d second/s.%n", Math.abs(clock));

            }
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


    private static int[] getArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
