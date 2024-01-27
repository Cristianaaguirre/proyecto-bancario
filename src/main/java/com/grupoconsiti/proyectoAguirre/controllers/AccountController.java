package com.grupoconsiti.proyectoAguirre.controllers;

import com.grupoconsiti.proyectoAguirre.models.dtos.AddAccountDTO;
import com.grupoconsiti.proyectoAguirre.models.repositories.AccountRepository;
import com.grupoconsiti.proyectoAguirre.services.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService accountService;
    private final AccountRepository repository;

    @PostMapping
    public ResponseEntity<?> addAccount(@RequestBody AddAccountDTO dto) {
        accountService.addAccount(dto);
        return ResponseEntity.status(201).build();
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getAccounts(@PathVariable Integer id) {
        return ResponseEntity.ok(accountService.getAccounts(id));
    }

}
