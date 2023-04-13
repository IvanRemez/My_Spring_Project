package com.cydeo.entity;

import com.cydeo.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Stack;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

//    @OneToOne(cascade = CascadeType.ALL)
    // ^^ lets Spring know that One Payment can have only One PaymentDetail
    // Cascade(ALL) = any DB actions (save, delete) done to the parent (Payment)
    // will also be done to the child (PaymentDetail)
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "payment_detail_id")
    // ^^ default name but can change foreign key column this way
    private PaymentDetail paymentDetail;

    @ManyToOne
    private Merchant merchant;

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
}
