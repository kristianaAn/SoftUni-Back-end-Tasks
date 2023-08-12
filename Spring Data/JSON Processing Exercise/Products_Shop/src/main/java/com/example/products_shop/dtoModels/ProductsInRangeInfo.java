package com.example.products_shop.dtoModels;

import com.example.products_shop.entities.Product;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProductsInRangeInfo {
    private String name;

    private BigDecimal price;

    @SerializedName(value = "seller")
    private String sellerFirstName;

    public static ProductsInRangeInfo getProductsInRangeInfo(Product product) {
        String sellerFullName = product.getSeller().getFirstName() + " " + product.getSeller().getLastName();
        return new ProductsInRangeInfo(product.getName(), product.getPrice(), sellerFullName);
    }
}
