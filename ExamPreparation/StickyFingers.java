package ExamPreparation;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[] movements = scanner.nextLine().split(",");


        String[][] matrix = getMatrix(scanner, matrixSize);

        int rowOfD = 0;
        int colofD = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("D")) {
                    rowOfD = row;
                    colofD = col;
                }
            }
        }
        int allMoney = 0;

        for (String movement : movements) {

            matrix[rowOfD][colofD] = "+";


            switch (movement) {
                case "up" -> {
                    if (rowOfD == 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        rowOfD -= 1;

                    }

                }
                case "down" -> {
                    if (rowOfD == matrixSize - 1) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        rowOfD += 1;

                    }
                }
                case "left" -> {
                    if (colofD == 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        colofD -= 1;

                    }
                }
                case "right" -> {
                    if (colofD == matrixSize - 1) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {

                        colofD += 1;
                    }
                }
            }
            String symbol =  matrix[rowOfD][colofD];


            switch (symbol) {
                case "+" -> {
                    matrix[rowOfD][colofD] = "D";

                }
                case "$" -> {
                    int sum = rowOfD * colofD;
                    allMoney += sum;
                    matrix[rowOfD][colofD] = "D";
                    System.out.printf("You successfully stole %d$.%n", sum);
                }
                case "P" -> {
                    System.out.printf("You got caught with %d$, and you are going to jail.%n", allMoney);
                    matrix[rowOfD][colofD] = "#";

                    printMatrix(matrix);

                    return;
                }
            }
        }


        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", allMoney);

        printMatrix(matrix);



    }

    private static void printMatrix(String [][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

        }

    }



    private static String[][] getMatrix(Scanner scanner, int matrixSize) {

        String[][] matrix = new String[matrixSize][matrixSize];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = getArray(scanner);


        }

        return matrix;
    }

    private static String[] getArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
