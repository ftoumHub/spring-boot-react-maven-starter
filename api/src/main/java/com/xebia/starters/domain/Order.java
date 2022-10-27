package com.xebia.starters.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(exclude = "id")
@ToString
@Value
public class Order {

    private UUID id;
    private String name;
    private String email;
    private String address;
    private String city;
    private String zip;
    private String country;
    private Boolean shipped;
    private List<OrderLine> products;
}
