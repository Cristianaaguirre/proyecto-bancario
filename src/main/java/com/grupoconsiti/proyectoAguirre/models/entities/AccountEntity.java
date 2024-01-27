package com.grupoconsiti.proyectoAguirre.models.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "account")
@Getter
@Setter
@Builder
public class AccountEntity {

    @Id
    private String accountNumber;
    private Integer codClient;
    private String accountName;
    private BigDecimal openingMount;
    private BigDecimal balance;
    @Column(columnDefinition = "DATE")
    private Date startDate;
    private String accountStatement;

    public AccountEntity() {
    }

    public AccountEntity(String accountNumber, Integer codClient, String accountName, BigDecimal openingMount, BigDecimal balance, Date date, String accountStatement) {
        this.accountNumber = accountNumber;
        this.codClient = codClient;
        this.accountName = accountName;
        this.openingMount = openingMount;
        this.balance = balance;
        this.startDate = date;
        this.accountStatement = accountStatement;
    }
}
