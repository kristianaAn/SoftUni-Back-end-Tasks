package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Getter
@Setter
@Entity
@Table(name = "credit_card")
public class CreditCard extends BillingDetail{
    @Column(name = "card_type", nullable = false)
    private String cardType;

    @Column(name = "expiration_month", nullable = false)
    private Short expirationMonth;

    @Column(name = "expiration_year", nullable = false)
    private Short expirationYear;

    public CreditCard() {
    }
}
