package com.grupoconsiti.proyectoAguirre.services;

import com.grupoconsiti.proyectoAguirre.models.dtos.AccountDetails;

public interface IGetInformation {
    AccountDetails getDetails(Integer codClient);
}
