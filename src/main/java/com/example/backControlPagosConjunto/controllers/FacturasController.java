package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.models.Facturas;
import com.example.backControlPagosConjunto.services.FacturasService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/facturas")
public class FacturasController extends BaseController<Facturas, String>{


    public FacturasController(FacturasService service) {
        super(service);
    }

    //Metodos adicionales

    //todo: Servicio de facturas con filtros
}
