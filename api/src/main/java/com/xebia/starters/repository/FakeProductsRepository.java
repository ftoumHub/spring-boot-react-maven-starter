package com.xebia.starters.repository;

import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import com.xebia.starters.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Repository
public class FakeProductsRepository {

    private Faker faker;
    private Commerce commerceFaker;

    private HashMap<String, Product> products ;

    public FakeProductsRepository() {
        this.faker = new Faker();
        this.commerceFaker = faker.commerce();
        this.products = new HashMap<>();
        initProducts();
    }

    private void initProducts() {
        String[] categories = new String[]{"Watersports", "Soccer", "Chess", "Running"};
        Random r = new Random();

        IntStream.range(1, 503)
                .forEach(i -> {
                    String category = categories[r.nextInt(categories.length)];
                    products.put(String.valueOf(i),
                            Product.builder()
                                    .id(String.valueOf(i))
                                    .name(commerceFaker.productName())
                                    .category(category)
                                    .description(category + ": " + faker.lorem().sentence(3))
                                    .price(Double.parseDouble(commerceFaker.price().replace(',','.')))
                                    .build());
                });
    }

    public Product findProduct(String id) {
        return products.get(id);
    }

    public List<Product> findAllProducts() {
        return new ArrayList<>(products.values());
    }

    public List<String> findAllCategories() {
        return products.values().stream().map(Product::getCategory).distinct().collect(toList());
    }
}
