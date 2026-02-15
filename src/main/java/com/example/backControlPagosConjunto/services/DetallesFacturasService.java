package com.example.backControlPagosConjunto.services;

import com.example.backControlPagosConjunto.dtos.models.DetallesFacturasDTO;

import java.util.List;
import java.util.UUID;

public interface DetallesFacturasService extends BaseService<DetallesFacturasDTO, UUID>{
    // Aquí puedes agregar métodos específicos para el modelo
    List<DetallesFacturasDTO> findByIdFactura(UUID idFactura);
}
