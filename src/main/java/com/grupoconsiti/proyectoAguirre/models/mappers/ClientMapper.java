package com.grupoconsiti.proyectoAguirre.models.mappers;

import com.grupoconsiti.proyectoAguirre.models.dtos.ClientDTO;
import com.grupoconsiti.proyectoAguirre.models.dtos.RegisterDTO;
import com.grupoconsiti.proyectoAguirre.models.entities.ClientEntity;

import java.util.Date;

public class ClientMapper {

    public static ClientDTO entityToDTO(ClientEntity entity) {
        return ClientDTO.builder()
                .codigo_cliente(entity.getCodClient())
                .DUI(entity.getDUI())
                .nombres(entity.getName())
                .apellidos(entity.getSurname())
                .build();
    }

    public static ClientEntity dtoToEntity(RegisterDTO dto, String accNum) {
        return ClientEntity.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .DUI(dto.getDUI())
                .accountNum(accNum)
                .startDate(new Date())
                .build();
    }
}
