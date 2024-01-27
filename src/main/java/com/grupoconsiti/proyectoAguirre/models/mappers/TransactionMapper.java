package com.grupoconsiti.proyectoAguirre.models.mappers;

import com.grupoconsiti.proyectoAguirre.models.dtos.TransaccionesDTO;
import com.grupoconsiti.proyectoAguirre.models.dtos.TransactionOperationDTO;
import com.grupoconsiti.proyectoAguirre.models.entities.TransactionEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TransactionMapper {

    public static TransaccionesDTO entityToDTO(TransactionEntity entity) {

        String type = entity.getTransactionTypeId() == 1 ? "Deposito" : "Retiro";
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");

        return TransaccionesDTO.builder()
                .type(type)
                .amount(entity.getAmount())
                .fecha(f.format(entity.getDate()))
                .build();
    }

    public static TransactionEntity operationToEntity(TransactionOperationDTO dto) {
        return TransactionEntity.builder()
                .amount(
                        dto.getTransactionTypeId() == 1
                                ? dto.getAmount()
                                : dto.getAmount().negate()
                )
                .date(new Date())
                .accountNum(dto.getAccountNum())
                .transactionTypeId(dto.getTransactionTypeId())
                .build();
    }

    public static List<TransaccionesDTO> listOfDTO(List<TransactionEntity> list) {
        return list.stream()
                .map(TransactionMapper::entityToDTO)
                .toList();
    }

}
