package com.kruger.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonManagedReference;
=======
import com.fasterxml.jackson.annotation.JsonProperty;
>>>>>>> 0814aa1bce31559d59b6ce1b8e712abd5125e6ac

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
<<<<<<< HEAD
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
=======
public class Cart {
	
>>>>>>> 0814aa1bce31559d59b6ce1b8e712abd5125e6ac
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
<<<<<<< HEAD
	//@JsonIgnore
	//@JsonManagedReference
	@OneToMany(mappedBy="card_id",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
=======

	@JsonIgnore
	@OneToMany(mappedBy="cartId",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
>>>>>>> 0814aa1bce31559d59b6ce1b8e712abd5125e6ac
	private List<Order> order;

	
	@PrePersist
	private void onCreate(){
		created = new Date();
	    }
<<<<<<< HEAD
=======

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

		


	

>>>>>>> 0814aa1bce31559d59b6ce1b8e712abd5125e6ac
	
}
