package com.grupoconsiti.proyectoAguirre.models.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@Builder
public class TransactionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;
    private BigDecimal amount;
    @Column(columnDefinition = "DATE")
    private Date date;
    private Integer transactionTypeId;
    private String accountNum;

    public TransactionEntity() {
    }

    public TransactionEntity(Integer transactionId, BigDecimal amount, Date date, Integer transactionTypeId, String accountNum) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
        this.transactionTypeId = transactionTypeId;
        this.accountNum = accountNum;
    }
}
