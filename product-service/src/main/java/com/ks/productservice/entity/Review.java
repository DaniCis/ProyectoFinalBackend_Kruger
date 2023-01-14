package com.ks.productservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




import java.io.Serializable;
/**
 * Modelo de entidad tabla review.
 * @author Edwin Pinchao
 *
 */
@Data
@Entity
@Table(name = "review")
@NoArgsConstructor
@AllArgsConstructor
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "rating", nullable = false,length = 100)
    private Integer rating;


    @Column(name = "text", nullable = false,length = 250)
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
}
