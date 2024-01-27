package com.grupoconsiti.proyectoAguirre.models.repositories;

import com.grupoconsiti.proyectoAguirre.models.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    boolean existsByDUI(String dui);
    ClientEntity findByCodClient(Integer codClient);
}
