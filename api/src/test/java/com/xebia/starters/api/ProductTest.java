package com.xebia.starters.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xebia.starters.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<Product> products;

    @Before
    public void init() throws IOException {
        products = Arrays.asList(objectMapper
                .readValue(new ClassPathResource("products.json").getFile(), Product[].class));
    }

    @Test
    public void parseProducts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Product> products = Arrays.asList(objectMapper
                .readValue(new ClassPathResource("products.json").getFile(), Product[].class));

        System.out.println(products);
    }

    @Test
    public void filterProducts() {
        final ProductsFilter productsFilter = new ProductsFilter("chess", 3, 2, "name");

        final List<Product> products = productsFilter.filterProducts(this.products);

        System.out.println("\n===== Resultat =====");
        products.forEach(p -> System.out.println(p));
    }
}
