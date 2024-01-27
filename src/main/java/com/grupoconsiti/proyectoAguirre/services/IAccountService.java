package com.grupoconsiti.proyectoAguirre.services;

import com.grupoconsiti.proyectoAguirre.models.dtos.AddAccountDTO;
import com.grupoconsiti.proyectoAguirre.models.entities.AccountEntity;

import java.util.List;

public interface IAccountService {
    AccountEntity getAccountByAccountNumber(String accountNumber);
    List<AccountEntity> getAccounts(Integer clientCod);
    void addAccount(AddAccountDTO dto);
}
