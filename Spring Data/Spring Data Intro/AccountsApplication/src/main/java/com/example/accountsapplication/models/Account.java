package com.example.accountsapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private BigDecimal balance;
    @ManyToOne
    private User user;

    public Account() {
        this.balance = BigDecimal.ZERO;
    }
}
