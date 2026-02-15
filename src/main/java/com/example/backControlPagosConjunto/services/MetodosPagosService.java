package com.example.backControlPagosConjunto.services;

import java.util.UUID;

import com.example.backControlPagosConjunto.dtos.models.MetodosPagosDTO;
import com.example.backControlPagosConjunto.models.MetodosPagos;

public interface MetodosPagosService extends BaseService<MetodosPagosDTO, UUID>{
    // Aquí puedes agregar métodos específicos para el modelo
    MetodosPagosDTO findByCodigo(String codigo);
}
