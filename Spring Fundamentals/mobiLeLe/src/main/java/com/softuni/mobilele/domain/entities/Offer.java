package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.BaseEntity;
import com.softuni.mobilele.domain.enums.Engine;
import com.softuni.mobilele.domain.enums.Transmission;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "offers")
@Getter
@Setter
public class Offer extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private Engine engine;

    @Column(name = "image_Url")
    private String imageUrl;

    @Column
    private int mileage;

    @Column
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @Column
    private int year;

    @Column
    private Date created;

    @Column
    private Date modified;

    @ManyToOne
    @JoinColumn(name = "model", referencedColumnName = "id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "seller" , referencedColumnName = "id")
    private User seller;

    public Offer() {
    }
}
