package lection_12_DefiningClasses_Exercise_CompanyRoster_02;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department) { //4
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public Employee(String name, double salary, String position, String department, String email) { //5
        this(name, salary, position, department);
        this.email = email;
        this.age = -1;
    }

    public Employee(String name, double salary, String position, String department, int age) { //5
        this(name, salary, position, department);
        this.email = "n/a";
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email, int age) { //6
        this(name, salary, position, department, email);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }
}
