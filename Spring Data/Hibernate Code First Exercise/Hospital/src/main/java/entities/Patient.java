package entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.ImageType;

import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String address;

    @Column
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column
    private ImageType picture;

    @Column(name = "has_medical_insurance")
    private boolean hasMedicalInsurance;

    @ManyToOne
    private Diagnose diagnoses;

    @ManyToOne
    private PrescribedMedicament prescribedMedicaments;

    @ManyToOne
    private Visitation visitations;

    public Patient(String firstName, String lastName, String address, String email,
                   Date date, BufferedImage bf, boolean hasInsurance) {
    }

    public Patient(ImageType picture) {
        super();
        this.picture = picture;
    }

    public Patient(String firstName, String lastName, String address, String email,
                   Date dateOfBirth, boolean hasMedicalInsurance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.hasMedicalInsurance = hasMedicalInsurance;
    }

    public Patient() {

    }
}
