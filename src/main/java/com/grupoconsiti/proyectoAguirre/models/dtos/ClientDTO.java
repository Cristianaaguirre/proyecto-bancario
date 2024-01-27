package com.grupoconsiti.proyectoAguirre.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ClientDTO {

    private Integer codigo_cliente;
    private String DUI;
    private String nombres;
    private String apellidos;

}
