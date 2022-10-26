package com.xebia.starters.domain;

import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(exclude = "id")
@Value
@ToString
public class Order {

    private UUID id;
    private String name;
    private String email;
    private String address;
    private String city;
    private String zip;
    private List<OrderLine> products;
}
