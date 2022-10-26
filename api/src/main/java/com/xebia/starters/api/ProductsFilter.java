package com.xebia.starters.api;

import com.xebia.starters.domain.Product;
import lombok.ToString;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Comparator.comparing;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@ToString
public class ProductsFilter {

    public final String category;
    public final Integer page;
    public final Integer pageSize;
    public final String sort;

    public ProductsFilter(String category, Integer page, Integer pageSize, String sort) {
        this.category = category;
        this.page = page;
        this.pageSize = pageSize;
        this.sort = sort;
    }

    public List<Product> filterProducts(List<Product> products) {
        System.out.println("filtering Products...");

        if (isNotBlank(category)) {
            products = products.stream()
                    .filter(p -> p.getCategory().equalsIgnoreCase(this.category))
                    .collect(toList());
        }

        if ("name".equalsIgnoreCase(sort)) products.sort(comparing(Product::getName));
        if ("category".equalsIgnoreCase(sort)) products.sort(comparing(Product::getCategory));
        if ("description".equalsIgnoreCase(sort)) products.sort(comparing(Product::getDescription));
        if ("price".equalsIgnoreCase(sort)) products.sort(comparing(Product::getPrice));

        //products.forEach(System.out::println);

        if (nonNullAndPositive(page) && nonNullAndPositive(pageSize)) {
            return getPage(products, page, pageSize);
        }

        return products;
    }

    /**
     * returns a view (not a new list) of the sourceList for the
     * range based on page and pageSize
     * @param sourceList
     * @param page, page numbre should start from 1
     * @param pageSize
     * @param
     * @return
     * custom error can be given instead of returning emptyList
     */
    public static <T> List<T> getPage(List<T> sourceList, int page, int pageSize) {
        if (pageSize <= 0 || page <= 0) {
            throw new IllegalArgumentException("invalid page size: " + pageSize);
        }

        int fromIndex = (page - 1) * pageSize;
        if (isNull(sourceList) || sourceList.size() <= fromIndex) {
            return emptyList();
        }

        return sourceList.subList(fromIndex, Math.min(fromIndex + pageSize, sourceList.size()));
    }

    public static boolean nonNullAndPositive(Integer entier) {
        return entier != null && entier > 0;
    }
}
