package com.example.thymeleafvalidation.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee extends BaseEntity {

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(name = "education_level", nullable = false)
    private String educationLevel;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    public Employee() {
    }
}
