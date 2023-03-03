package lection_03_Encapsulation_lab.SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (getAge() < 30) {
            salary = salary + ((salary * (bonus / 100)) / 2);
        } else {
            salary = salary + (salary * (bonus / 100));
        }
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.3f leva", firstName, lastName, salary);
    }
}
