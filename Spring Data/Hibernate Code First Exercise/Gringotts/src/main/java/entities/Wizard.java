package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wizards")
public class Wizard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;
    @Column(length = 1000)
    private String notes;
    @Basic
    private int age;
    @OneToOne
    @JoinColumn
    private MagicWand magicWand;
    @OneToMany(mappedBy = "wizard", targetEntity = Deposit.class)
    private List<Deposit> depositList;

    public Wizard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MagicWand getMagicWand() {
        return magicWand;
    }

    public void setMagicWand(MagicWand magicWand) {
        this.magicWand = magicWand;
    }

    public List<Deposit> getDepositList() {
        return depositList;
    }

    public void setDepositList(List<Deposit> depositList) {
        this.depositList = depositList;
    }
}

