package com.example.thymeleafvalidation.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
public class Employee extends BaseEntity {

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(name = "education_level", nullable = false)
    private String educationLevel;

    @Column(name = "first_name", nullable = false)
    private String firstName; /*Must be at least 2 characters. Cannot be null.*/

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "last_name", nullable = false)
    private String lastName; /*Must be at least 2 characters. Cannot be null.*/

    @Column(nullable = false)
    private BigDecimal salary; /*(must be a positive number)*/

    @OneToOne
    private Company company;

    public Employee() {
    }
}
