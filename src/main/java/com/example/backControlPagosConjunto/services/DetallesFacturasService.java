package com.example.backControlPagosConjunto.services;

import com.example.backControlPagosConjunto.dtos.models.DetallesFacturasDTO;

import java.util.List;

public interface DetallesFacturasService extends BaseService<DetallesFacturasDTO, String>{
    // Aquí puedes agregar métodos específicos para el modelo
    List<DetallesFacturasDTO> findByIdFactura(String idFactura);
}
