package com.example.backControlPagosConjunto.services;

import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.dtos.operatives.FacturasFilterDTO;
import com.example.backControlPagosConjunto.models.Facturas;
import org.springframework.data.domain.Page;

public interface FacturasService extends BaseService<FacturasDTO, String>{
    // Aquí puedes agregar métodos específicos para el modelo
    Page<Facturas> findAllWithFilters(FacturasFilterDTO filterDTO);
}
