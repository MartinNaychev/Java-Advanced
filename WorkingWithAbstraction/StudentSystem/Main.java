package WorkingWithAbstraction.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String input = scanner.nextLine();

        while (!input.equals("Exit")) {

            studentSystem.ParseCommand(input);
            input = scanner.nextLine();
        }
    }
}
