package com.kruger.app.model;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ordenes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
	@Column(name="totalPrice" , nullable = false)
    private double totalPrice;
	@Column(name="status", nullable = false,length = 100)
    private String status;
	@Column(name="ShipmentAddres", nullable = false,length = 100)
    private String ShipmentAddres;
	@Column(name="Shipmentdate", nullable = false,length = 100)
    private Date Shipmentdate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, updatable = false)
	private Date created;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Cart cart;
	
	@OneToOne(mappedBy="order")
	private Orderitem orderitem;
	
	@PrePersist
	private void onCreate(){
		created = new Date();
	    }
}
