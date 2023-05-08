package additionalExercise;

import java.util.Scanner;

public class BonusScoringSystem_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfStudents = Integer.parseInt(scanner.nextLine());
        int numOfLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double maxPoints = Integer.MIN_VALUE;

        int maxBonusAttendanceCount = 0;
        boolean isZero = false;

        if (numOfStudents == 0 && numOfLectures == 0) {
            maxPoints = 0;
            maxBonusAttendanceCount = 0;
        } else {
            for (int i = 1; i <= numOfStudents; i++) {
                int studentAttendanceCount = Integer.parseInt(scanner.nextLine());
                double totalBonus = 0;
                totalBonus = (studentAttendanceCount * 1.0 / numOfLectures) * (5 + additionalBonus);

                if (totalBonus >= maxPoints) {
                    maxPoints = totalBonus;
                    maxBonusAttendanceCount = studentAttendanceCount;
                }
            }
        }

        if (isZero) {
            System.out.println("Max Bonus: 0.");
            System.out.println();
            System.out.println("The student has attended 0 lectures.");
        } else {
            System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxPoints));
            System.out.printf("The student has attended %d lectures.", maxBonusAttendanceCount);
        }

    }
}
