package com.ks.productservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;
/**
 * Modelo de entidad tabla category.
 * @author Edwin Pinchao
 *
 */
@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

  
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;

    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Product> products;




}
