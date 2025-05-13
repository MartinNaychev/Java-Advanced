package SetsAndMaps;

import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Double> students = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = getGrade(scanner);
            double aveGrade = getAveGrade(grades);
            students.putIfAbsent(name, aveGrade);


        }
        for (var student : students.entrySet()) {
            String studentName = student.getKey();
            double studentAveGrade = student.getValue();
            System.out.printf("%s is graduated with %s%n", studentName,studentAveGrade);

        }


    }

    private static double getAveGrade(double[] grades) {
        double aveGrade = 0.00;
        for (double grade : grades) {
            aveGrade += grade;
        }
        return aveGrade/grades.length;
    }

    private static double[] getGrade(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
