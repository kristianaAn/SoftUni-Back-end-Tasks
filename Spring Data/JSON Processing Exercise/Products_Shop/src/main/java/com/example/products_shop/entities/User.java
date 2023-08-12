package com.example.products_shop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column
    private int age;

    @OneToMany(targetEntity = Product.class, mappedBy = "buyer")
    private List<Product> productsBuyerList;

    @OneToMany(targetEntity = Product.class, mappedBy = "seller")
    private List<Product> productsSellerList;

    @ManyToMany
    private List<User> friends;
}
