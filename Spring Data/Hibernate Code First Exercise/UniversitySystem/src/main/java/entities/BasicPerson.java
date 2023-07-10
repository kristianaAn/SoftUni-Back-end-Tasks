package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public abstract class BasicPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;
}
