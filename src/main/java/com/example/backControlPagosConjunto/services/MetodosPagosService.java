package com.example.backControlPagosConjunto.services;

import com.example.backControlPagosConjunto.dtos.models.MetodosPagosDTO;
import com.example.backControlPagosConjunto.models.MetodosPagos;

public interface MetodosPagosService extends BaseService<MetodosPagosDTO, String>{
    // Aquí puedes agregar métodos específicos para el modelo
    MetodosPagosDTO findByCodigo(String codigo);
}
