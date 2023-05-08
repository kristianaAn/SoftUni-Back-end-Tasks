package Lection_11_Objects_and_Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students_v2_06 {
    private static class Students {
        String firstName;
        String lastName;
        int age;
        String homeTown;

        public Students(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return this.age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getHomeTown() {
            return this.homeTown;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputCommand = scanner.nextLine();

        List<Students> allStudents = new ArrayList<>();

        while (!inputCommand.equals("end")) {
            String[] studentData = inputCommand.split(" ");

            String firstNameStudent = studentData[0];
            String lastNameStudent = studentData[1];
            int ageStudent = Integer.parseInt(studentData[2]);
            String townStudent = studentData[3];

            Students currentStudent = new Students(firstNameStudent, lastNameStudent, ageStudent, townStudent);

            if (studentExists(allStudents, firstNameStudent, lastNameStudent)) {
                Students studentToReplace = getUpdatedStudent(allStudents, firstNameStudent, lastNameStudent);

                studentToReplace.setFirstName(firstNameStudent);
                studentToReplace.setLastName(lastNameStudent);
                studentToReplace.setAge(ageStudent);
                studentToReplace.setHomeTown(townStudent);
            } else {
                allStudents.add(currentStudent);
            }

            inputCommand = scanner.nextLine();
        }

        String city = scanner.nextLine();

        for (Students town : allStudents) {
            if (town.getHomeTown().equals(city)) {
                System.out.println("" + town.getFirstName() + " " + town.getLastName() + " is " + town.getAge() + " years old");
            }
        }
    }

    public static boolean studentExists (List<Students> allStuds, String firstName, String lastName) {
        for (Students currStudent : allStuds) {
            if (currStudent.getFirstName().equals(firstName) && currStudent.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    public static Students getUpdatedStudent (List<Students> allStudents, String firstN, String lastN) {
        Students updatedData = null;
        for (Students studToReplace : allStudents) {
            if (studToReplace.getFirstName().equals(firstN) && studToReplace.getLastName().equals(lastN)) {
                updatedData = studToReplace;
            }
        }
        return updatedData;
    }
}
