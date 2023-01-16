package com.kruger.app.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Data;


@Entity
@Table(name = "Cart")
@Data
public class Cart {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@JsonIgnore
	@OneToMany(mappedBy="cartId",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Order> order;

	
	@PrePersist
	private void onCreate(){
		created = new Date();
	    }

		public Cart() {
		}

		@JsonCreator
		public Cart(@JsonProperty("id") int id, @JsonProperty("created") Date created) {
			this.id = id;
			this.created = created;
		}

		@Override
		public String toString() {
			return "Cart [id=" + id + ", created=" + created + ", order=" + order + "]";
		}

		


	

	
}
