package com.example.products_shop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends BaseEntity{
    @Column
    private String name;

    @ManyToMany(targetEntity = Product.class)
    @JoinTable(name = "products_categories")
    private List<Product> productList;
}
