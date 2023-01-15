package com.kruger.app.common;

import lombok.Data;

@Data
public class Product {

	private Long id; 
    private String name;
    private String description;
    private double price;
    private Integer quantity;
    private boolean status;   
    private Integer salesCounter;
}
