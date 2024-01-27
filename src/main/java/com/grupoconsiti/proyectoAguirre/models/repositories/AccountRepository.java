package com.grupoconsiti.proyectoAguirre.models.repositories;

import com.grupoconsiti.proyectoAguirre.models.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    boolean existsByAccountNumber(String accountNum);
    AccountEntity findByAccountNumber(String accountNumber);
    List<AccountEntity> findAllByCodClient(Integer codClient);
}
