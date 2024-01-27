package com.grupoconsiti.proyectoAguirre.services.impl;

import com.grupoconsiti.proyectoAguirre.models.dtos.RegisterDTO;
import com.grupoconsiti.proyectoAguirre.models.entities.ClientEntity;
import com.grupoconsiti.proyectoAguirre.models.mappers.ClientMapper;
import com.grupoconsiti.proyectoAguirre.models.repositories.ClientRepository;
import com.grupoconsiti.proyectoAguirre.services.IClientService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;

    public ClientEntity getClient(Integer cod) {
        return Optional.ofNullable(clientRepository.findByCodClient(cod))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No existe cliente registrado"));
    }

    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    public void registerClient(RegisterDTO dto) {
        if(clientRepository.existsByDUI(dto.getDUI())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Usuario ya registrado en la plataforma");
        } else {
            var client = ClientMapper.dtoToEntity(dto, generateAccountNum());
            clientRepository.save(client);
        }
    }

    private String generateAccountNum() {
        return RandomStringUtils.randomNumeric(10);
    }



}
