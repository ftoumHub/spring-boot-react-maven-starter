package com.xebia.starters.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xebia.starters.domain.Product;
import io.vavr.Tuple2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class ProductTest {

    private static List<Product> products;

    @BeforeAll
    public static void init() throws IOException {
        products = Arrays.asList(new ObjectMapper()
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

        final Tuple2<Integer, List<Product>> products = productsFilter.filterProducts(this.products);

        System.out.println("\n===== Resultat =====");
        products._2.forEach(System.out::println);
    }
}
