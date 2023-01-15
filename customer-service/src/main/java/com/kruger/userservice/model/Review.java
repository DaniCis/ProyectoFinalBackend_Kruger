package com.kruger.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private Long id;
    private Integer rating;
    private String text;
    private Product product;
}
