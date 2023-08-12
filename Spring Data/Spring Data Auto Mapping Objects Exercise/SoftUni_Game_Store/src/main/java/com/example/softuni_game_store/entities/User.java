package com.example.softuni_game_store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Game> games;

    @OneToMany(mappedBy = "user", targetEntity = Order.class, fetch = FetchType.EAGER)
    Set<Order> orders;

    public User(String email, String password, String fullName, boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.isAdmin = isAdmin;
    }

    public User() {
    }
}
