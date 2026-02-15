package com.example.backControlPagosConjunto.services;

import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.dtos.models.PagosDTO;

import java.util.List;
import java.util.UUID;

public interface PagosService extends BaseService<PagosDTO, UUID>{
    // Aquí puedes agregar métodos específicos para el modelo

    List<PagosDTO> findByIdFactura(UUID idFactura);
    Boolean revisarYgeneracionPagoManual(FacturasDTO factura);
}
