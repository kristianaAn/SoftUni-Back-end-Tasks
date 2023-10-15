package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity {

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "id")
    private UserRole role;

    @Column
    private String imageUrl;

    @Column
    private Date created;

    @Column
    private Date modified;

    @OneToMany(targetEntity = Offer.class, mappedBy = "seller")
    private List<Offer> sellerOffers;

    public User() {
    }
}
