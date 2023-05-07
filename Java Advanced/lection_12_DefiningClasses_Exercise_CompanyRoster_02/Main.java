package lection_12_DefiningClasses_Exercise_CompanyRoster_02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Department> departments = new ArrayList<>();
        Employee employee = null;

        for (int i = 1; i <= n; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String name = inputData[0];
            double salary = Double.parseDouble(inputData[1]);
            String position = inputData[2];
            String employeeDepartment = inputData[3];

            if (inputData.length == 4) {

                employee = new Employee(name, salary, position, employeeDepartment);

            } else if (inputData.length == 5) {

                if (inputData[4].contains("@")) {
                    String email = inputData[4];
                    employee = new Employee(name, salary, position, employeeDepartment, email);

                } else {
                    int age = Integer.parseInt(inputData[4]);
                    employee = new Employee(name, salary, position, employeeDepartment, age);

                }

            } else if (inputData.length == 6) {

                String email = inputData[4];
                int age = Integer.parseInt(inputData[5]);

                employee = new Employee(name, salary, position, employeeDepartment, email, age);

            }

            //след всички проверки, получавам един обект Employee

            boolean departmentExist = departments
                    .stream()
                    .anyMatch(department -> department.getName().equals(employeeDepartment));

            if (!departmentExist) {
                Department department = new Department(employeeDepartment);
                departments.add(department);
            }

            Department currentDepartment = departments.stream()
                    .filter(dep -> dep.getName().equals(employeeDepartment))
                    .findFirst()
                    .get();

            currentDepartment.getListEmployees().add(employee);

        }

        Department highestPaidDepartment = departments
                .stream()
                .max(Comparator.comparingDouble(Department::calculateAverageSalary))
                .get();

        System.out.println("Highest Average Salary: " + highestPaidDepartment.getName());

        highestPaidDepartment
                .getListEmployees()
                .stream()
                .sorted((l, r) -> Double.compare(r.getSalary(), l.getSalary()))
                .forEach(System.out::println);
    }
}
