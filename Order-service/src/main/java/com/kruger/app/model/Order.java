package com.kruger.app.model;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
	@Column(name="totalPrice" , updatable = false) 
    private double totalPrice;
	@Column(name="status", length = 100,updatable = false)
    private String status;
	@Column(name="ShipmentAddres",length = 100,updatable = false)
    private String ShipmentAddres;
	@Column(name="Shipmentdate", length = 100,updatable = false)
    private Date Shipmentdate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created",  updatable = false)
	private Date created;
	

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "cart_id")
    private Cart cartId;
	
	@OneToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "orderItems")
	private Orderitem orderItems;


	@JsonIgnore
	@OneToMany(mappedBy="orderId",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Payment> payment;


	
	@PrePersist
	private void onCreate(){
		created = new Date();
	    }

	public Order( double totalPrice, String status, String shipmentAddres, Date shipmentdate, Date created,
			Cart cartId, Orderitem orderitem, Payment paymentId) {
		this.totalPrice = totalPrice;
		this.status = status;
		ShipmentAddres = shipmentAddres;
		Shipmentdate = shipmentdate;
		this.created = created;
		this.cartId = cartId;
	}

	


	
	
}
