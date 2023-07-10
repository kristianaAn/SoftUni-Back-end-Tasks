package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "prescribed_medicament")
public class PrescribedMedicament extends MedicalHistory {
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "prescribedMedicaments", targetEntity = Patient.class)
    private List<Patient> patients;

    public PrescribedMedicament() {
    }

    public PrescribedMedicament(String name) {
        this.name = name;
    }
}
