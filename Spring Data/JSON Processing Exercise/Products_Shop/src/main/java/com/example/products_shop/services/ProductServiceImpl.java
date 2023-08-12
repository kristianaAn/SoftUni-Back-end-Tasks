package com.example.products_shop.services;

import com.example.products_shop.dtoModels.ProductsInRangeInfo;
import com.example.products_shop.entities.Product;
import com.example.products_shop.repositories.ProductRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.products_shop.constants.Utils.GSON;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductsInRangeInfo> findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal low, BigDecimal high) throws IOException {
        List<ProductsInRangeInfo> productsInRangeInfos = this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(low, high)
                .stream()
                .map(ProductsInRangeInfo::getProductsInRangeInfo)
                .collect(Collectors.toList());

        System.out.println(GSON.toJson(productsInRangeInfos));

        writeToJSONFile(productsInRangeInfos, Path.of("src/main/resources/output/1.output.json"));

        return productsInRangeInfos;
    }

    private void writeToJSONFile(List<ProductsInRangeInfo> productsInRangeInfos, Path path) throws IOException {
        FileWriter fileWriter = new FileWriter(path.toFile());

        GSON.toJson(productsInRangeInfos, fileWriter);

        fileWriter.flush();
        fileWriter.close();
    }

}

