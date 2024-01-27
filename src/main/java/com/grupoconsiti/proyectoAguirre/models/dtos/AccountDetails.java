package com.grupoconsiti.proyectoAguirre.models.dtos;

import java.util.List;

public record AccountDetails(ClientDTO cliente, List<AccountDTO> cuentas) {
}
