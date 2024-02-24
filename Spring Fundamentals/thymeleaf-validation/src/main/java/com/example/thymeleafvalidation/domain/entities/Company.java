package com.example.thymeleafvalidation.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "companies")
@Getter
@Setter
@AllArgsConstructor
public class Company extends BaseEntity {

    @Column(nullable = false)
    private BigDecimal budget; /*(must be a positive number). */

    @Column(columnDefinition = "TEXT")
    private String description; /* Must be at least 10 characters.*/

    @Column(nullable = false, unique = true)
    private String name; /*Must be between 2 and 10 characters.*/

    @Column(nullable = false)
    private String town; /* Must be between 2 and 10 characters*/

    public Company() {
    }
}


