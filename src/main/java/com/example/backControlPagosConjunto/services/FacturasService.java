package com.example.backControlPagosConjunto.services;

import com.example.backControlPagosConjunto.dtos.general.GeneralFilterDTO;
import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.dtos.models.custom.FacturasMiniDTO;
import com.example.backControlPagosConjunto.dtos.operatives.FacturasFilterDTO;

import java.util.List;

public interface FacturasService extends BaseService<FacturasDTO, String>{
    // Aquí puedes agregar métodos específicos para el modelo
    List<FacturasDTO> findAllWithFilters(FacturasFilterDTO filterDTO);
    List<FacturasMiniDTO> findAllbynombreResidenteORcodigo(GeneralFilterDTO filterDTO);
}
