package students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Students> studentsList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String firstName = input.split(" ")[0];
            String lastName = input.split(" ")[1];
            double grade = Double.parseDouble(input.split(" ")[2]);

            Students students = new Students(firstName, lastName, grade);
            studentsList.add(students);
        }


        studentsList.sort(Comparator.comparingDouble(Students::getGrade).reversed());

        for (Students eachStudent : studentsList) {
            System.out.println(eachStudent.toString());
        }
    }
}
