package DefiningClassesExercise.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> employeeMap = new HashMap<>();

        while (rows-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            String email = "n/a";
            int age = -1;


            if (input.length == 6) {
                email = input[4];
                age = Integer.parseInt(input[5]);


            } else if (input.length == 5) {
                String ageOrEmail = input[4];
                if (ageOrEmail.contains("@")) {
                    email = ageOrEmail;
                } else {
                    age = Integer.parseInt(ageOrEmail);
                }

            }
            Employee employee = employee = new Employee(name, salary, position, department, email, age);


            if (!employeeMap.containsKey(department)) {
                List<Employee> currentEmployeeList = new ArrayList<>();
                currentEmployeeList.add(employee);
                employeeMap.put(department, currentEmployeeList);
            } else {
                employeeMap.get(department).add(employee);
            }
        }
        String highestAve = employeeMap.entrySet().stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                .get().getKey();
        System.out.println("Highest Average Salary: " + highestAve);
        List<Employee> employeesInDepartment = employeeMap.get(highestAve);
        employeesInDepartment.sort(Comparator.comparing(Employee::getSalary));
        Collections.reverse(employeesInDepartment);

        for (Employee employee : employeesInDepartment) {
            StringBuilder builder = new StringBuilder();
            builder.append(employee.getName() + " ")
                    .append(String.format("%.2f ", employee.getSalary()))
                    .append(employee.getEmail() + " ")
                    .append(employee.getAge());
            System.out.println(builder);
        }
    }

    private static double getAverageSalary(List<Employee> employees) {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();

        }
        return sum / employees.size();
    }
}
