package com.example.backControlPagosConjunto.services;

import com.example.backControlPagosConjunto.dtos.general.GeneralFilterDTO;
import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.dtos.models.custom.FacturasMiniDTO;
import com.example.backControlPagosConjunto.dtos.operatives.FacturasFilterDTO;

import java.util.List;
import java.util.UUID;

public interface FacturasService extends BaseService<FacturasDTO, UUID>{
    // Aquí puedes agregar métodos específicos para el modelo
    List<FacturasDTO> findAllWithFilters(FacturasFilterDTO filterDTO);
    List<FacturasMiniDTO> findAllbynombreResidenteORcodigo(GeneralFilterDTO filterDTO);
    Boolean pagoManualFactura(UUID idFactura);
}
