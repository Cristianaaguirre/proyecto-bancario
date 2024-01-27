package com.grupoconsiti.proyectoAguirre.services;

import com.grupoconsiti.proyectoAguirre.models.dtos.RegisterDTO;
import com.grupoconsiti.proyectoAguirre.models.entities.ClientEntity;

import java.util.List;

public interface IClientService {
    void registerClient(RegisterDTO dto);
    List<ClientEntity> getAllClients();
    ClientEntity getClient(Integer cod);
}
