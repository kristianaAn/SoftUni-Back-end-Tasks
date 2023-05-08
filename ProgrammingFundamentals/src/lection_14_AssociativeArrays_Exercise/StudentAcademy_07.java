package lection_14_AssociativeArrays_Exercise;

import java.util.*;

public class StudentAcademy_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentPlusGrade = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentPlusGrade.containsKey(studentName)) {
                studentPlusGrade.put(studentName, new ArrayList<>());
                studentPlusGrade.get(studentName).add(grade);
            } else {
                studentPlusGrade.get(studentName).add(grade);
            }
        }

        Map<String, Double> studentsToPrint = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : studentPlusGrade.entrySet()) {
            double sum = 0;
            int count = 0;
            for (double grade : entry.getValue()) {
                sum += grade;
                count++;
            }
            double average = sum / count;
            if (average >= 4.50) {
                studentsToPrint.put(entry.getKey(), average);
            }
        }
            studentsToPrint.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));
    }
}
