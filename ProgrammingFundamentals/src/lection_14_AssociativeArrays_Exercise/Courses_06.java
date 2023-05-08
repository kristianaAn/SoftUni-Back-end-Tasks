package lection_14_AssociativeArrays_Exercise;

import java.util.*;

public class Courses_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();

        Map<String, List<String>> courseAndStudentName = new LinkedHashMap<>();
        Map<String, Integer> courseAndStudentsCount = new LinkedHashMap<>();
        while (!inputData.equals("end")) {
            String course = inputData.split(" : ")[0];
            String studentName = inputData.split(" : ")[1];

            if (!courseAndStudentName.containsKey(course)) {
                courseAndStudentName.put(course, new ArrayList<>());
                courseAndStudentName.get(course).add(studentName);
            } else {
                courseAndStudentName.get(course).add(studentName);
            }

            if (!courseAndStudentsCount.containsKey(course)) {
                courseAndStudentsCount.put(course, 1);
            } else {
                courseAndStudentsCount.put(course, courseAndStudentsCount.get(course) + 1);
            }

            inputData = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : courseAndStudentName.entrySet()) {
            for (Map.Entry<String, Integer> integerEntry : courseAndStudentsCount.entrySet()) {
                if (entry.getKey().equals(integerEntry.getKey())) {
                    System.out.println("" + entry.getKey() + ": " + integerEntry.getValue());
                    for (String name : entry.getValue()) {
                        System.out.printf("-- %s%n", name);
                    }
                }
            }

        }

    }
}
