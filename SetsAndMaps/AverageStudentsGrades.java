package SetsAndMaps;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, List<Double>> studentRecord = new TreeMap<>();

        int input = Integer.parseInt(scanner.nextLine());

        while (input-- > 0) {
            String[] studentAndGrade = scanner.nextLine().split("\\s+");

            String name = studentAndGrade[0];
            double grade = Double.parseDouble(studentAndGrade[1]);

            studentRecord.putIfAbsent(name, new ArrayList<>());
            studentRecord.get(name).add(grade);

        }
        for (var student : studentRecord.entrySet()) {
            String name = student.getKey();
            List<Double> grades = student.getValue();
            double aveGrade = getAveGrade(grades);
            StringBuilder listWithGrades = new StringBuilder();

            for (Double grade : grades) {
                listWithGrades.append(String.format("%.2f ", grade));
            }

            System.out.printf("%s -> %s(avg: %.2f)%n",name,listWithGrades,aveGrade);


        }


    }

    private static double getAveGrade(List<Double> grades) {
        double aveGrade = 0.00;
        for (Double grade : grades) {
            aveGrade+=grade;
        }
        return aveGrade/=grades.size();
    }
}
