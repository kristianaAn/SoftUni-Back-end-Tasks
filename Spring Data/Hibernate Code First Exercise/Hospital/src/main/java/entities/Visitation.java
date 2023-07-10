package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "visitations")
public class Visitation extends MedicalHistory{
    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String comments;

    @OneToMany(mappedBy = "visitations", targetEntity = Patient.class)
    private List<Patient> patients;

    public Visitation() {
    }

    public Visitation(Date date, String comments) {
        this.date = date;
        this.comments = comments;
    }
}
