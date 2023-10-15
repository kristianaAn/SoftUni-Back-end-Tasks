package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "brands")
@Getter
@Setter
public class Brand extends BaseEntity {

    @Column
    private Date created;

    @Column
    private Date modified;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "brand", targetEntity = Model.class)
    private List<Model> models;

    public Brand() {
    }
}
