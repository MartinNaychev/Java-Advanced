package MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        StringBuilder creatingDegrees = new StringBuilder();
        for (char symbol : command.toCharArray()) {
            if (Character.isDigit(symbol)) {
                creatingDegrees.append(symbol);
            }
        }
        int degrees = Integer.parseInt(creatingDegrees.toString()) / 90;

        String input = scanner.nextLine();
        List<String> words = new ArrayList<>();
        while (!input.equals("END")) {
            words.add(input);
            input = scanner.nextLine();
        }


        int matrixRow = words.size();
        int matrixCol = getMatrixCol(words);
        char[][] matrix = new char[matrixRow][matrixCol];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = getWord(words, row, matrixCol);

        }

        for (int i = 1; i <= degrees; i++) {
            matrix = getRotateMatrix90(matrix);

        }
printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

        }
    }

    private static char[][] getRotateMatrix90(char[][] matrix) {
        int newRow = matrix[0].length;
        int newCol = matrix.length;
        char[][] newMatrix = new char[newRow][newCol];

        for (int col = 0; col < newRow; col++) {
            int counter = 0;
            for (int row = newCol - 1; row >= 0; row--) {
                char symbol = matrix[row][col];
                newMatrix[col][counter] = symbol;
                counter++;
            }

        }
        return newMatrix;
    }

        private static char[] getWord (List < String > words,int row, int matrixCol){

            char[] word = words.get(row).toCharArray();
            List<String> newWord = new ArrayList<>();
            for (char symbol : word) {
                newWord.add(String.valueOf(symbol));
            }
            if (newWord.size() < matrixCol) {
                while (newWord.size() != matrixCol) {
                    newWord.add(" ");
                }
            }
            char[] newSymbolArray = new char[matrixCol];
            for (int symbol = 0; symbol < matrixCol; symbol++) {
                char currentSymbol = newWord.get(symbol).charAt(0);
                newSymbolArray[symbol] = currentSymbol;

            }

            return newSymbolArray;
        }


        private static int getMatrixCol (List < String > words) {

            int longestWord = 0;
            for (String word : words) {
                int length = word.length();

                if (length > longestWord) {
                    longestWord = length;
                }
            }
            return longestWord;
        }

}