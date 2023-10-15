package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.BaseEntity;
import com.softuni.mobilele.domain.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "models")
@Getter
@Setter
public class Model extends BaseEntity {

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "start_year")
    private int startYear;

    @Column(name = "end_year")
    private int endYear;

    @Column
    private Date created;

    @Column
    private Date modified;

    @ManyToOne
    @JoinColumn(name = "brand", referencedColumnName = "id")
    private Brand brand;

    @OneToMany(targetEntity = Offer.class, mappedBy = "model")
    private List<Offer> offers;

    public Model() {

    }
}