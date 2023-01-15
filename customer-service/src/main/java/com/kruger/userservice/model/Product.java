package com.kruger.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private Integer quantity;
    private boolean status;
    private Integer salesCounter;
    private Date createAt;
    private Category category;
}
