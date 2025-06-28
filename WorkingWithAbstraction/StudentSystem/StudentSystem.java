package WorkingWithAbstraction.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {

    private Map<String, Student> studentMap;

    public StudentSystem() {

        this.studentMap = new HashMap<>();
    }


    public void ParseCommand(String parts) {
//        Scanner scanner = new Scanner(System.in);
       String[] inputParts = parts.split("\\s+") ;

        String command = inputParts[0];
        String name = inputParts[1];

        if (command.equals("Create")) {
            int age = Integer.parseInt(inputParts[2]);
            double grade = Double.parseDouble(inputParts[3]);

            Student student = new Student(name, age, grade);
            studentMap.putIfAbsent(name, student);

        } else {

            if (studentMap.containsKey(name)) {
                Student student = studentMap.get(name);
                String output = String.format("%s is %s years old.", student.getName(), student.getAge());

                if (student.getGrade() >= 5.00) {
                    output += " Excellent student.";
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    output += " Average student.";
                } else {
                    output += " Very nice person.";
                }

                System.out.println(output);
            }
        }
    }
}
