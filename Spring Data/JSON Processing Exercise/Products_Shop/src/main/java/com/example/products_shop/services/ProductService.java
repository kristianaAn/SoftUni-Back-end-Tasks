package com.example.products_shop.services;

import com.example.products_shop.dtoModels.ProductsInRangeInfo;
import com.example.products_shop.entities.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
      List<ProductsInRangeInfo> findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal low, BigDecimal high) throws IOException;
}
