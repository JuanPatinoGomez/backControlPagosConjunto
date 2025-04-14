package com.example.backControlPagosConjunto.services;

import com.example.backControlPagosConjunto.dtos.operatives.FacturasFilterDTO;
import com.example.backControlPagosConjunto.models.Facturas;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FacturasService extends BaseService<Facturas, String>{
    // Aquí puedes agregar métodos específicos para el modelo
    Page<Facturas> findAllWithFilters(FacturasFilterDTO filterDTO);
}
