package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "diagnoses")
public class Diagnose extends MedicalHistory{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String comments;

    @OneToMany(mappedBy = "diagnoses", targetEntity = Patient.class)
    private List<Patient> patients;

    public Diagnose() {
    }
    public Diagnose(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }
}
