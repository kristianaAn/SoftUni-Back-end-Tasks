package lection_05_SetsAndMapsAdvanced_lab;

import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List <Double>> studentsAndGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String studentName = input.split("\\s+")[0];
            double grade = Double.parseDouble(input.split("\\s+")[1]);

            if (!studentsAndGrades.containsKey(studentName)) {
                studentsAndGrades.put(studentName, new ArrayList<>());
                studentsAndGrades.get(studentName).add(grade);
            } else {
                studentsAndGrades.get(studentName).add(grade);
            }
        }

        //Stephan -> 5.20 3.20 (avg: 4.20)

        for (Map.Entry<String, List<Double>> entry : studentsAndGrades.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Double grade : entry.getValue()) {
                System.out.printf("%.2f ", grade);
            }
            printAverageGrade(entry.getValue());
            System.out.println();
        }

    }

    private static void printAverageGrade(List<Double> grade) {
        double sum = 0;
        for (Double num : grade) {
            sum += num;
        }
        System.out.printf("(avg: %.2f)", sum / grade.size());
    }
}
