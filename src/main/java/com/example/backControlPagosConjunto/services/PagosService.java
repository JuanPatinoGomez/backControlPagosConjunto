package com.example.backControlPagosConjunto.services;

import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.dtos.models.PagosDTO;

import java.util.List;

public interface PagosService extends BaseService<PagosDTO, String>{
    // Aquí puedes agregar métodos específicos para el modelo

    List<PagosDTO> findByIdFactura(String idFactura);
    Boolean revisarYgeneracionPagoManual(FacturasDTO factura);
}
