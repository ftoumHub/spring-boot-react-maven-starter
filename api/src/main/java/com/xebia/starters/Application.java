package com.xebia.starters;

import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import com.xebia.starters.domain.Order;
import com.xebia.starters.domain.OrderLine;
import com.xebia.starters.domain.Product;
import com.xebia.starters.repository.OrderRepository;
import com.xebia.starters.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.*;

import static java.util.stream.IntStream.range;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void initRepositories() {
        Faker faker = new Faker(new Locale("fr"));
        Commerce commerceFaker = faker.commerce();
        Random random = new Random();

        String[] categories = new String[]{"Watersports", "Soccer", "Chess", "Running"};

        range(1, 504)
                .forEach(i -> {
                    String category = categories[random.nextInt(categories.length)];
                    productRepository.saveProduct(
                            Product.builder()
                                    .id(String.valueOf(i))
                                    .name(commerceFaker.productName())
                                    .category(category)
                                    .description(category + ": " + faker.lorem().sentence(3))
                                    .price(Double.parseDouble(commerceFaker.price().replace(',', '.')))
                                    .build());
                });

        List<Product> products = productRepository.findAllProducts();

        range(1, 104)
                .forEach(i -> {
                            var order = Order.builder()
                                    .id(UUID.randomUUID())
                                    .name(faker.name().firstName() + " " + faker.name().lastName())
                                    .email(faker.internet().emailAddress())
                                    .address(faker.address().streetAddress())
                                    .city(faker.address().city())
                                    .zip(faker.address().zipCode())
                                    .country("France")
                                    .shipped(faker.random().nextBoolean()).build();

                            List<OrderLine> orderLines = new ArrayList<>();
                            var productCount = faker.random().nextInt(1, 5);
                            for (int j = 0; j < productCount; j++) {
                                var candidateId = faker.random().nextInt(1, products.size());
                                var orderLine = new OrderLine(
                                        String.valueOf(candidateId),
                                        String.valueOf(faker.random().nextInt(1, 10)));
                                orderLines.add(orderLine);
                            }

                            order = order.toBuilder().products(orderLines).build();
                            orderRepository.saveOrder(order);
                        }
                );
    }

}
