package com.xebia.starters.api;

import com.xebia.starters.domain.Product;
import com.xebia.starters.repository.ProductRepository;
import com.xebia.starters.utils.LogUtils;
import io.vavr.Tuple2;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.xebia.starters.utils.LogUtils.logAsJsonObjet;

@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "x-total-count")
@RestController
public class ProductResource {
    private static final Logger logger = LoggerFactory.getLogger(ProductResource.class);
    private final ProductRepository productRepository;

    public ProductResource(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/api/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        final Product product = productRepository.findProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping(path = "/api/products")
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(name = "category_like", required = false) String category,
            @RequestParam(name = "_page", required = false) Integer page,
            @RequestParam(name = "_limit", required = false) Integer limit,
            @RequestParam(name = "_sort", required = false) String sort
    ) {
        logger.info("GET: /api/products");

        var productsFilter = new ProductsFilter(category, page, limit, sort);
        logAsJsonObjet(logger, "ProductsFilter : \n{}", new JSONObject(productsFilter));

        final List<Product> products = productRepository.findAllProducts();
        final Tuple2<Integer, List<Product>> paginatedProducts = productsFilter.filterProducts(products);

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-total-count", String.valueOf(paginatedProducts._1));

        return ResponseEntity.ok()
                .headers(headers)
                .body(paginatedProducts._2);
    }


    @GetMapping(path = "/api/categories")
    public ResponseEntity<List<String>> getAllCategories() {
        logger.info("GET: /api/categories");
        final List<String> categories = productRepository.findAllCategories();
        return ResponseEntity.ok(categories);
    }

    /**
     * Requête graphql pour voir la liste :
     * query {
     *   allProducts {id name category description price}
     * }
     */
    @SchemaMapping(typeName = "Query",value = "allProducts")
    public List<Product> findAll() {
        return productRepository.findAllProducts();
    }

    /**
     * query {
     *   product(id: "313") {id name category description price}
     * }
     */
    @QueryMapping
    public Product product(@Argument String id) {
        return productRepository.findProduct(id);
    }

    @MutationMapping
    public Product storeProduct(@Argument ProductStore productStore) {
        LogUtils.logAsJsonObjet(logger, "\n{}", new JSONObject(productStore));
        return productRepository.saveProduct(toDomain(productStore));
    }

    private Product toDomain(ProductStore productStore) {
        return Product.builder()
                .id(String.valueOf(productRepository.newId()))
                .name(productStore.getName())
                .category(productStore.getCategory())
                .description(productStore.getDescription())
                .price(productStore.getPrice())
                .build();
    }
}
