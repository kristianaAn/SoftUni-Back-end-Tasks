package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "bank_account")
@Getter
@Setter
public class BankAccount extends BillingDetail{
    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "swift_code")
    private String swiftCode;

    public BankAccount() {
    }
}
