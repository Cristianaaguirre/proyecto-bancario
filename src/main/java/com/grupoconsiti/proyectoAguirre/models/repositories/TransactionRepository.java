package com.grupoconsiti.proyectoAguirre.models.repositories;

import com.grupoconsiti.proyectoAguirre.models.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {

    List<TransactionEntity> findAllByAccountNum(String accountNum);
}
