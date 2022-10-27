package com.xebia.starters.repository;

import com.xebia.starters.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class ProductRepository {

    private final HashMap<String, Product> products;

    public ProductRepository() {
        this.products = new HashMap<>();
    }

    public void saveProduct(Product product) {
        this.products.put(String.valueOf(product.getId()), product);
    }

    public Product findProduct(String id) {
        return products.get(id);
    }

    public List<Product> findAllProducts() {
        return new ArrayList<>(this.products.values());
    }

    public List<String> findAllCategories() {
        return products.values().stream().map(Product::getCategory).distinct().collect(toList());
    }
}
