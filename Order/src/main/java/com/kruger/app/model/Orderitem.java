package com.kruger.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Orderitem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orderitem {
	
	@Id
    @Column(name="id")
    private int id;
	@Column(name="product")
    private double product;
	@Column(name="quantity")
    private String quantity;
	@Column(name="created")
    private String created;


}
