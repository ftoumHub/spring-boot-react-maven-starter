package com.xebia.starters.repository;

import com.xebia.starters.domain.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.xebia.starters.repository.ProductsHelper.productList;
import static java.util.stream.Collectors.toList;

@Repository
public class ProductsRepository {

    private HashMap<String, Product> products ;

    public ProductsRepository(ApplicationContext appContext) throws IOException {
        //Resource productsJson = appContext.getResource("classpath:products.json");

        this.products = new HashMap<>();

        //ObjectMapper objectMapper = new ObjectMapper();

        //List<Product> productList = asList(objectMapper
                //.readValue(productsJson.getFile(), Product[].class));
                //.readValue(new ClassPathResource("sportstore/products.json").getFile(), Product[].class));
        productList.forEach(p -> products.put(p.getId(), p));
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
