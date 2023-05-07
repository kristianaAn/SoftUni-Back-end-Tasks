package lection_01_WorkingWithAbstraction_lab.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void create(String studentName, int studentAge, double studentGrade) {
        if (!repo.containsKey(studentName)) {
            Student student = new Student(studentName, studentAge, studentGrade);
            repo.put(studentName, student);
        }
    }

    public void show(String studentName) {
        if (repo.containsKey(studentName)) {
            var student = repo.get(studentName);
            String view = String.format("%s is %s years old.", student.getName(), student.getAge());

            if (student.getGrade() >= 5.00) {
                view += " Excellent student.";
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                view += " Average student.";
            } else {
                view += " Very nice lection_06_Inheritance_Exercise.person.";
            }

            System.out.println(view);
        }
    }
}
