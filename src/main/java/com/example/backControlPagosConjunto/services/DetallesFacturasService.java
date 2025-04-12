package com.example.backControlPagosConjunto.services;

import com.example.backControlPagosConjunto.dtos.DetallesFacturasDTO;
import com.example.backControlPagosConjunto.models.DetallesFacturas;

import java.util.List;

public interface DetallesFacturasService extends BaseService<DetallesFacturas, String>{
    // Aquí puedes agregar métodos específicos para el modelo
    List<DetallesFacturasDTO> findByIdFactura(String idFactura);
}
