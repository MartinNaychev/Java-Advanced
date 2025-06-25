package Exam;

import java.util.Scanner;

public class PirateQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];

        int startRow = 0;
        int startCol = 0;
        int allTreasures = 0;

        for (int row = 0; row < sizeOfMatrix; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < sizeOfMatrix; col++) {
                String currentSymbol = String.valueOf(line[col]);
                matrix[row][col] = currentSymbol;
                if (currentSymbol.equals("S")) {
                    startRow = row;
                    startCol = col;
                }
                if (currentSymbol.equals("*")) {
                    allTreasures++;
                }
            }
        }

        int duration = 100;
        // int totalCollectTreasures = 0;
        boolean heal = false;
        String command = scanner.nextLine();

        while (!command.equals("stop") && duration > 0 && allTreasures > 0) {
            matrix[startRow][startCol] = ".";


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

            if (matrix[startRow][startCol].equals("*")) {
                allTreasures--;
            } else if (matrix[startRow][startCol].equals("C") && !heal) {
                heal=true;
                duration+=25;
                if (duration>100){
                    duration=100;
                }
            } else if (matrix[startRow][startCol].equals("M")) {
                duration-=25;

            }


            matrix[startRow][startCol] = "S";
            command = scanner.nextLine();
        }


        if (duration<=0){
            System.out.printf("Shipwreck! Last known coordinates (%d, %d)%n",startRow,startCol);
            System.out.printf("Ship Durability: %d%n",duration);
        } else if (allTreasures<=0) {
            System.out.println("Yo-ho-ho! All treasure chests collected!");
            System.out.printf("Ship Durability: %d%n",duration);
        }else {
            System.out.println("Retreat! Some treasures remain unclaimed.");
            System.out.printf("Ship Durability: %d%n",duration);
        }

        if (allTreasures>0){
            System.out.printf("Unclaimed chests: %d%n",allTreasures);
        }

        getPrintMatrix(matrix);
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
