package com.xebia.starters.domain;

import lombok.*;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Value
public class OrderLine {

    private String product_id;
    private String quantity;
}
