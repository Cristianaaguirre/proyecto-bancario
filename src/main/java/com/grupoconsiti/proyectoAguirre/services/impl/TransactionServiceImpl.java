package com.grupoconsiti.proyectoAguirre.services.impl;

import com.grupoconsiti.proyectoAguirre.models.dtos.TransactionOperationDTO;
import com.grupoconsiti.proyectoAguirre.models.entities.TransactionEntity;
import com.grupoconsiti.proyectoAguirre.models.mappers.TransactionMapper;
import com.grupoconsiti.proyectoAguirre.models.repositories.TransactionRepository;
import com.grupoconsiti.proyectoAguirre.services.IAccountService;
import com.grupoconsiti.proyectoAguirre.services.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements ITransactionService {

    private final TransactionRepository transactionRepository;
    private final IAccountService accountService;

    public void transactionBanking(TransactionOperationDTO dto) {

        var accounts = accountService.getAccounts(dto.getClientCod());

        accounts.stream()
                .filter(a -> a.getAccountNumber().equals(dto.getAccountNum()))
                .findFirst()
                .ifPresent(
                a -> {
                    if(a.getBalance().compareTo(dto.getAmount()) >= 0 && a.getAccountStatement().equals("A")) {
                        var transaction = TransactionMapper.operationToEntity(dto);
                        transactionRepository.save(transaction);
                    } else {
                        throw new ResponseStatusException(HttpStatus.CONFLICT, "No se pudo completar la transaccion, revisar los datos");
                    }
                }
        );
    }

    public List<TransactionEntity> getTransactions(String numAccount) {
        return transactionRepository.findAllByAccountNum(numAccount);
    }

}
