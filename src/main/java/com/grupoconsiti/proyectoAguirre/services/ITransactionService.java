package com.grupoconsiti.proyectoAguirre.services;

import com.grupoconsiti.proyectoAguirre.models.dtos.TransactionOperationDTO;
import com.grupoconsiti.proyectoAguirre.models.entities.TransactionEntity;

import java.util.List;

public interface ITransactionService {
    void transactionBanking(TransactionOperationDTO dto);
    List<TransactionEntity> getTransactions(String numAccount);
}
