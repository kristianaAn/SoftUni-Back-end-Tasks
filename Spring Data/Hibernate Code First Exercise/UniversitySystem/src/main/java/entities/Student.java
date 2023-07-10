package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student extends BasicPerson{
    @Column(name = "average_grade")
    private double averageGrade;
    @Column
    private double attendance;

    @ManyToMany(mappedBy = "students", targetEntity = Course.class)
    private List<Course> courses;

    public Student() {
    }

    public Student(double averageGrade, double attendance, List<Course> courses) {
        super();
        this.averageGrade = averageGrade;
        this.attendance = attendance;
        this.courses = courses;
    }
}
