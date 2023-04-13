package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "merchants")
@Data
@NoArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private BigDecimal transactionFee;
    private BigDecimal commissionRate;
    private Integer payoutDelayCount;

    @OneToMany(mappedBy = "merchant")
    // ^^ mappedBy prevents Spring from creating a foreign Key in Merchant table (which
    // leads to 3rd table creation to deal with OneToMany not fitting in the same row)
    // In OneToMany relation -> ownership belongs to Many side (Payment)
    private List<Payment> paymentList;
    // ^^ must be List b/c Merchant has MULTIPLE payments
// ^^ No need for Bi-Directional if you don't plan to access paymentList through Merchant
    public Merchant(String name, String code, BigDecimal transactionFee,
                    BigDecimal commissionRate, Integer payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.transactionFee = transactionFee;
        this.commissionRate = commissionRate;
        this.payoutDelayCount = payoutDelayCount;
    }
}
