package com.grupoconsiti.proyectoAguirre.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class AccountDTO {

    private BigDecimal saldo;
    private String estado;
    private List<TransaccionesDTO> transacciones;

}


