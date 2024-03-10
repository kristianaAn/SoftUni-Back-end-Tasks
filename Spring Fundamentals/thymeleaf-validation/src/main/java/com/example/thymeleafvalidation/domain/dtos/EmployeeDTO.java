package com.example.thymeleafvalidation.domain.dtos;

import com.example.thymeleafvalidation.domain.entities.Company;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO extends BaseEntityDTO {

    @NotNull
    @Size(min = 2)
    private String firstName;

    @NotNull
    @Size(min = 2)
    private String lastName;

    @NotNull
    private String educationLevel;

    @NotNull
    private String company;

    @NotNull
    private String jobTitle;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private BigDecimal salary;
    public EmployeeDTO() {
    }

}
