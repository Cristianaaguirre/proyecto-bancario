package com.grupoconsiti.proyectoAguirre.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class TransactionOperationDTO {

    private Integer clientCod;
    private String accountNum;
    private BigDecimal amount;
    private Integer transactionTypeId;

}
