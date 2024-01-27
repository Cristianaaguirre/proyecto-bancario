package com.grupoconsiti.proyectoAguirre.models.mappers;

import com.grupoconsiti.proyectoAguirre.models.dtos.AccountDTO;
import com.grupoconsiti.proyectoAguirre.models.dtos.AddAccountDTO;
import com.grupoconsiti.proyectoAguirre.models.entities.AccountEntity;
import com.grupoconsiti.proyectoAguirre.models.entities.TransactionEntity;

import java.util.Date;
import java.util.List;

public class AccountMapper {

    public static AccountDTO entityToDTO(AccountEntity entity, List<TransactionEntity> list) {
        return AccountDTO.builder()
                .saldo(entity.getBalance())
                .estado(entity.getAccountStatement())
                .transacciones(
                        TransactionMapper.listOfDTO(list)
                )
                .build();
    }

    public static AccountEntity dtoToEntity(AddAccountDTO dto) {
        return AccountEntity.builder()
                .accountNumber(dto.getAccountNum())
                .codClient(dto.getClientCod())
                .accountName(dto.getAccountName())
                .openingMount(dto.getOpeningAmount())
                .balance(dto.getOpeningAmount())
                .startDate(new Date())
                .accountStatement(dto.getAccountStatement())
                .build();
    }
}
