package com.kruger.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
    @Column(name="id")
    private int id;
	@Column(name="totalPrice")
    private double totalPrice;
	@Column(name="status")
    private String status;
	@Column(name="ShipmentAddres")
    private String ShipmentAddres;
	@Column(name="Shipmentdate")
    private String Shipmentdate;
	

}
