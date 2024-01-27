package com.grupoconsiti.proyectoAguirre.controllers;

import com.grupoconsiti.proyectoAguirre.models.dtos.TransactionOperationDTO;
import com.grupoconsiti.proyectoAguirre.services.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionsController {

    private final ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> transactionOperation(@RequestBody TransactionOperationDTO operation) {
        transactionService.transactionBanking(operation);
        return ResponseEntity.status(200).build();
    }

}
