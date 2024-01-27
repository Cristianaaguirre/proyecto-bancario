package com.grupoconsiti.proyectoAguirre.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction_type")
public class TransactionTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionTypeId;
    private String transactionName;

    public TransactionTypeEntity() {}

    public TransactionTypeEntity(Integer transactionTypeId, String transactionName) {
        this.transactionTypeId = transactionTypeId;
        this.transactionName = transactionName;
    }
}
