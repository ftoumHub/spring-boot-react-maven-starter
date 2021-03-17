package com.xebia.starters.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xebia.starters.domain.Product;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductTest {

    @Test
    public void parseProducts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Product> products = Arrays.asList(objectMapper
                .readValue(new ClassPathResource("products.json").getFile(), Product[].class));

        System.out.println(products);
    }
}
