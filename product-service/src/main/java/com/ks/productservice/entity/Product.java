package com.ks.productservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Modelo de entidad tabla product.
 * @author Edwin Pinchao
 *
 */
@Data
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name", nullable = false,length = 100)
    private String name;

    @Column(name = "description", nullable = false,length = 100)
    private String description;

    @Column(name = "price", nullable = false,length = 100)
    private double price;

    @Column(name = "quantity", nullable = false,length = 100)
    private Integer quantity;

    @Column(name = "status", nullable = false,length = 100)
    private boolean status;

    @Column(name = "sales_counter", nullable = false,length = 100)
    private Integer salesCounter;


    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviews;




}
