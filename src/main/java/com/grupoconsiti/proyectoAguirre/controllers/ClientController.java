package com.grupoconsiti.proyectoAguirre.controllers;

import com.grupoconsiti.proyectoAguirre.models.dtos.RegisterDTO;
import com.grupoconsiti.proyectoAguirre.services.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @GetMapping
    public ResponseEntity<?> getClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping
    public ResponseEntity<?> addClient(@RequestBody RegisterDTO dto) {
        clientService.registerClient(dto);
        return ResponseEntity.status(201).build();
    }



}
