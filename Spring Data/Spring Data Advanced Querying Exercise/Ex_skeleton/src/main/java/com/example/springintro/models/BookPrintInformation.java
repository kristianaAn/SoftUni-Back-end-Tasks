package com.example.springintro.models;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.EditionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class BookPrintInformation {
    private String title;
    private EditionType editionType;
    private AgeRestriction ageRestriction;
    private BigDecimal price;

    public BookPrintInformation(String title, EditionType editionType, AgeRestriction ageRestriction, BigDecimal price) {
        this.title = title;
        this.editionType = editionType;
        this.ageRestriction = ageRestriction;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.title + " " + this.editionType + " " + this.ageRestriction + " " + this.price;
    }
}
