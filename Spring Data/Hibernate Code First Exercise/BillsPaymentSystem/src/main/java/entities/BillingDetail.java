package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(unique = true)
    private String number;

    @OneToMany(mappedBy = "billingDetail", targetEntity = User.class, cascade = CascadeType.ALL)
    private List<User> owners;

    public BillingDetail() {
    }
}
