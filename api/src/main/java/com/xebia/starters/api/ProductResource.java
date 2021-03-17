package com.xebia.starters.api;

import com.xebia.starters.domain.Product;
import com.xebia.starters.repository.ProductsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductResource {

    ProductsRepository productRepository;

    public ProductResource(ProductsRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/api/products/{id}")
    public ResponseEntity getProduct(@PathVariable String id) {
        final Product product = productRepository.findProduct(id);
        return ResponseEntity.ok(product);
    }

    @CrossOrigin
    @GetMapping(path = "/api/products")
    public ResponseEntity getAllProducts() {
        final List<Product> products = productRepository.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @CrossOrigin
    @GetMapping(path = "/api/categories")
    public ResponseEntity getAllCategories() {
        final List<String> categories = productRepository.findAllCategories();
        return ResponseEntity.ok(categories);
    }
}
