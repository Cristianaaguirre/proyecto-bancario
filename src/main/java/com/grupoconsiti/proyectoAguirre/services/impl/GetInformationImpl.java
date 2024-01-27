package com.grupoconsiti.proyectoAguirre.services.impl;

import com.grupoconsiti.proyectoAguirre.models.dtos.AccountDetails;
import com.grupoconsiti.proyectoAguirre.models.mappers.AccountMapper;
import com.grupoconsiti.proyectoAguirre.models.mappers.ClientMapper;
import com.grupoconsiti.proyectoAguirre.services.IAccountService;
import com.grupoconsiti.proyectoAguirre.services.IClientService;
import com.grupoconsiti.proyectoAguirre.services.IGetInformation;
import com.grupoconsiti.proyectoAguirre.services.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetInformationImpl implements IGetInformation {

    private final IClientService clientService;
    private final IAccountService accountService;
    private final ITransactionService transactionService;

    public AccountDetails getDetails(Integer codClient) {
        var client = ClientMapper.entityToDTO(clientService.getClient(codClient));

        var accounts = accountService.getAccounts(codClient)
                .stream()
                .map(a -> AccountMapper.entityToDTO(a, transactionService.getTransactions(a.getAccountNumber())))
                .toList();

        return new AccountDetails(
                client,
                accounts
        );

    }

}
