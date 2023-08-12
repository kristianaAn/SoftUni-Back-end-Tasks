package com.example.products_shop.services;

import com.example.products_shop.dtoModels.CategoryImportModel;
import com.example.products_shop.dtoModels.ProductImportModel;
import com.example.products_shop.dtoModels.UserImportModel;
import com.example.products_shop.entities.Category;
import com.example.products_shop.entities.Product;
import com.example.products_shop.entities.User;
import com.example.products_shop.repositories.CategoryRepository;
import com.example.products_shop.repositories.ProductRepository;
import com.example.products_shop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.example.products_shop.constants.Utils.GSON;

@Service
public class SeedServiceImpl implements SeedService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public SeedServiceImpl(CategoryRepository categoryRepository,
                           ProductRepository productRepository,
                           UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void seedUsers() throws IOException {
        if (this.userRepository.count() > 0) {
            return;
        }

        ModelMapper modelMapper = new ModelMapper();

        FileReader fileReader = new FileReader(Path.of("src/main/resources/db_files/users.json").toFile());

        List<User> userList = Arrays.stream(GSON.fromJson(fileReader, UserImportModel[].class))
                .map(userImportModel -> modelMapper.map(userImportModel, User.class))
                .collect(Collectors.toList());

        userRepository.saveAll(userList);

        fileReader.close();
    }

    @Override
    public void seedProducts() throws IOException {
        if (this.productRepository.count() > 0) {
            return;
        }

        ModelMapper modelMapper = new ModelMapper();

        FileReader fileReader = new FileReader(Path.of("src/main/resources/db_files/products.json").toFile());

        List<Product> productList = Arrays.stream(GSON.fromJson(fileReader, ProductImportModel[].class))
                .map(productImportModel -> modelMapper.map(productImportModel, Product.class))
                .map(this::setRandomBuyer)
                .map(this::setRandomSeller)
                .collect(Collectors.toList());

        this.productRepository.saveAll(productList);

        fileReader.close();
    }

    private Product setRandomSeller(Product product) {
        User seller = this.userRepository.getRandomEntity()
                .orElseThrow(NoSuchElementException::new);

        while (product.getBuyer() != null && product.getBuyer().getId() == seller.getId()) {
            seller = this.userRepository.getRandomEntity()
                    .orElseThrow(NoSuchElementException::new);
        }

        product.setSeller(seller);

        return product;
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepository.count() > 0) {
            return;
        }

        ModelMapper modelMapper = new ModelMapper();

        FileReader fileReader = new FileReader(Path.of("src/main/resources/db_files/categories.json").toFile());

        List<Category> categoryList = Arrays.stream(GSON.fromJson(fileReader, CategoryImportModel[].class))
                .map(categoryImportModel -> modelMapper.map(categoryImportModel, Category.class))
                .map(this::setRandomCategory)
                .collect(Collectors.toList());

        categoryRepository.saveAll(categoryList);

        fileReader.close();
    }

    private Category setRandomCategory(Category category) {
        final Random random = new Random();

        int bound = random.nextInt((int) this.productRepository.count());

        List<Product> products = new ArrayList<>();

        IntStream.range(1, bound)
                .forEach(value -> {
                    products.add(this.productRepository.getRandomEntity().orElseThrow(NoSuchElementException::new));
                });

        category.setProductList(products);

        return category;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(750L)) > 0) {
            User buyer = this.userRepository.getRandomEntity()
                    .orElseThrow(NoSuchElementException::new);

            product.setBuyer(buyer);
        }

        return product;
    }
}
