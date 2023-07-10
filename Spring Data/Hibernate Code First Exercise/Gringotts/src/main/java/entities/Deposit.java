package entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "deposits")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "deposit_group", length = 20)
    private String depositGroup;
    @Column(name = "deposit_start_date")
    private LocalDateTime depositStartDate;
    @Column(name = "deposit_amount")
    private double deposit_amount;
    @Column(name = "deposit_interest")
    private double deposit_interest;
    @Column(name = "deposit_charge")
    private double deposit_charge;
    @Column(name = "deposit_expiration_date")
    private LocalDateTime deposit_expiration_date;
    @Column(name = "is_deposit_expired")
    private boolean is_deposit_expired;
    @ManyToOne
    private Wizard wizard;

    public Deposit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public LocalDateTime getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(LocalDateTime depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public double getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(double deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public double getDeposit_interest() {
        return deposit_interest;
    }

    public void setDeposit_interest(double deposit_interest) {
        this.deposit_interest = deposit_interest;
    }

    public double getDeposit_charge() {
        return deposit_charge;
    }

    public void setDeposit_charge(double deposit_charge) {
        this.deposit_charge = deposit_charge;
    }

    public LocalDateTime getDeposit_expiration_date() {
        return deposit_expiration_date;
    }

    public void setDeposit_expiration_date(LocalDateTime deposit_expiration_date) {
        this.deposit_expiration_date = deposit_expiration_date;
    }

    public boolean isIs_deposit_expired() {
        return is_deposit_expired;
    }

    public void setIs_deposit_expired(boolean is_deposit_expired) {
        this.is_deposit_expired = is_deposit_expired;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }
}
