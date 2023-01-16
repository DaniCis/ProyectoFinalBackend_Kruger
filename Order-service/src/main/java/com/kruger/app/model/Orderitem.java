package com.kruger.app.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "Orderitem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orderitem {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
	@Column(name="product", nullable = false)
    private double product;
	@Column(name="quantity", nullable = false,length = 100)
    private Integer quantity;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, updatable = false)
	private Date created;
	
	@OneToOne
	@JoinColumn(name="order_id")
	private Order order;


	@PrePersist
	private void onCreate(){
		created = new Date();
	    }


}
