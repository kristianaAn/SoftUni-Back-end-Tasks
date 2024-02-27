package com.example.thymeleafvalidation.domain.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CompanyDTO extends BaseEntityDTO {
    @NotNull
    @Positive
    private BigDecimal budget;

    @Size(min = 10)
    private String description;

    @NotNull
    @Size(min = 2, max = 10)
    private String name;

    @NotNull
    @Size(min = 2, max = 10)
    private String town;

    public CompanyDTO() {
    }
}
