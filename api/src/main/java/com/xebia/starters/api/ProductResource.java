package com.xebia.starters.api;

import com.xebia.starters.domain.Product;
import com.xebia.starters.repository.FakeProductsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductResource {

    private static final Logger logger = LoggerFactory.getLogger(ProductResource.class);

    FakeProductsRepository fakeProductsRepository;

    public ProductResource(FakeProductsRepository fakeProductsRepository) {
        this.fakeProductsRepository = fakeProductsRepository;
    }

    @GetMapping(path = "/api/products/{id}")
    public ResponseEntity getProduct(@PathVariable String id) {
        final Product product = fakeProductsRepository.findProduct(id);
        return ResponseEntity.ok(product);
    }

    @CrossOrigin
    @GetMapping(path = "/api/products")
    public ResponseEntity getAllProducts(@RequestParam(name = "category_like", required = false) String category,
                                         @RequestParam(name = "_page", required = false) Integer page,
                                         @RequestParam(name = "_limit", required = false) Integer limit,
                                         @RequestParam(name = "_sort", required = false) String sort) {
        logger.info("==> getAllProducts");
        logger.info("filters :");
        logger.info("category_like : " + category);
        logger.info("_page : " + page);
        logger.info("_limit : " + limit);
        logger.info("_sort : " + sort);

        //service.getAllProducts

        final List<Product> products = fakeProductsRepository.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @CrossOrigin
    @GetMapping(path = "/api/categories")
    public ResponseEntity getAllCategories() {
        final List<String> categories = fakeProductsRepository.findAllCategories();
        return ResponseEntity.ok(categories);
    }
}
