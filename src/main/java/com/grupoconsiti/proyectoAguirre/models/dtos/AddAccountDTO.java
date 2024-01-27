package com.grupoconsiti.proyectoAguirre.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class AddAccountDTO {

    private Integer clientCod;
    private String accountNum;
    private String accountName;
    private BigDecimal openingAmount;
    private String accountStatement;

}
