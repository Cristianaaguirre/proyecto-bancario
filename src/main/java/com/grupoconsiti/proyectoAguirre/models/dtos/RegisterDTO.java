package com.grupoconsiti.proyectoAguirre.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterDTO {

    private String name;
    private String surname;
    private String DUI;

}
