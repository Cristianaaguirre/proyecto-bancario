package com.grupoconsiti.proyectoAguirre.services.impl;

import com.grupoconsiti.proyectoAguirre.models.dtos.AddAccountDTO;
import com.grupoconsiti.proyectoAguirre.models.entities.AccountEntity;
import com.grupoconsiti.proyectoAguirre.models.mappers.AccountMapper;
import com.grupoconsiti.proyectoAguirre.models.repositories.AccountRepository;
import com.grupoconsiti.proyectoAguirre.services.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;

    public AccountEntity getAccountByAccountNumber(String accountNumber) {
        return Optional.of(accountRepository.findByAccountNumber(accountNumber))
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado")
                );
    }

    public List<AccountEntity> getAccounts(Integer clientCod) {
        return accountRepository.findAllByCodClient(clientCod);
    }

    public void addAccount(AddAccountDTO dto) {

        if(dto.getOpeningAmount().compareTo(BigDecimal.ZERO) <= 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se puede operar con montos negativos");

        boolean clientAccounts = getAccounts(dto.getClientCod())
                .stream().anyMatch(a -> a.getAccountNumber().equals(dto.getAccountNum()));

        if(clientAccounts)
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya posee un usuario registrado con ese numero de cuenta");
        else {
            var account = AccountMapper.dtoToEntity(dto);
            accountRepository.save( account );
        }
    }


}
