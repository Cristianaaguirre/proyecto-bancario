package com.grupoconsiti.proyectoAguirre.models.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "client")
@Getter
@Setter
@Builder
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codClient;
    private String name;
    private String surname;
    private String DUI;
    @Column(columnDefinition = "DATE")
    private Date startDate;
    private String accountNum;

    public ClientEntity() {
    }

    public ClientEntity(Integer id, String name, String surname, String DUI, Date startDate, String accountNum) {
        this.codClient = id;
        this.name = name;
        this.surname = surname;
        this.DUI = DUI;
        this.startDate = startDate;
        this.accountNum = accountNum;
    }
}
