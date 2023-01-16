package com.kruger.app.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    public Payment(String status, UUID payPallPaymentId, Date created, Order order) {
        this.status = status;
        this.payPallPaymentId = payPallPaymentId;
        this.created = created;
    }
    
    @Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    private UUID payPallPaymentId;

    @Temporal(TemporalType.DATE)
    private Date created;

    
}
