package com.grupoconsiti.proyectoAguirre.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class TransaccionesDTO {

    private String type;
    private BigDecimal amount;
    private String fecha;

}
