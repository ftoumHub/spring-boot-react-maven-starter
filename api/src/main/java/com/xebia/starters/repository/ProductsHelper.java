package com.xebia.starters.repository;

import com.xebia.starters.domain.Product;

import java.util.Arrays;
import java.util.List;

public class ProductsHelper {

    static List<Product> productList = Arrays.asList(
            Product.builder()
                    .id("1").name("Kayak").category("Watersports")
                    .description("A boat for one person").price(275d).build(),
            Product.builder()
                    .id("2").name("Lifejacket").category("Watersports")
                    .description("Protective and fashionable").price(48.95).build(),
            Product.builder()
                    .id("3").name("Soccer Ball").category("Soccer")
                    .description("FIFA-approved size and weight").price(19.5).build(),
            Product.builder()
                    .id("4").name("Corner Flags").category("Soccer")
                    .description("Give your playing field a professional touch").price(34.95).build(),
            Product.builder()
                    .id("5").name("Stadium").category("Soccer")
                    .description("Flat-packed 35,000-seat stadium").price(79500d).build(),
            Product.builder()
                    .id("6").name("Thinking Cap").category("Chess")
                    .description("Improve brain efficiency by 75%").price(16d).build(),
            Product.builder()
                    .id("7").name("Unsteady Chair").category("Chess")
                    .description("Secretly give your opponent a disadvantage").price(29.95).build(),
            Product.builder()
                    .id("8").name("Human Chess Board").category("Chess")
                    .description("A fun game for the family").price(75d).build(),
            Product.builder()
                    .id("9").name("Bling Bling King").category("Chess")
                    .description("Gold-plated, diamond-studded King").price(1200d).build()
    );
    private ProductsHelper() {
        // don't instantiate me
    }
}
