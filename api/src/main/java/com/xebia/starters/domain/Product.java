package com.xebia.starters.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor
@Builder(toBuilder = true)
@Value
public class Product {

    String id;
    String name;
    String category;
    String description;
    Double price;

    public Product() {
        this(null, null, null, null, null);
    }
}
