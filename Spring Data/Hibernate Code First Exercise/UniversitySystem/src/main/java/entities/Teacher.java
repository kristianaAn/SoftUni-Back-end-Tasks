package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher extends BasicPerson{
    @Column
    private String email;

    @Column(name = "salary_per_hour")
    private double salaryPerHour;

    @OneToMany(mappedBy = "teacher", targetEntity = Course.class)
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(String email, double salaryPerHour, List<Course> courses) {
        super();
        this.email = email;
        this.salaryPerHour = salaryPerHour;
        this.courses = courses;
    }
}
