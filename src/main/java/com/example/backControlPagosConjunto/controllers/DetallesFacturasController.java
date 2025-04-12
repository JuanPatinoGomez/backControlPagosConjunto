package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.DetallesFacturasDTO;
import com.example.backControlPagosConjunto.models.DetallesFacturas;
import com.example.backControlPagosConjunto.services.DetallesFacturasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/detallesFacturas")
public class DetallesFacturasController extends BaseController<DetallesFacturas, String>{

    private final DetallesFacturasService service;

    public DetallesFacturasController(DetallesFacturasService service) {
        super(service);
        this.service = service;
    }

    //Metodos adicionales

    //todo: Servicio por factura

    @GetMapping("/factura/{idFactura}")
    public List<DetallesFacturasDTO> getFactura(@PathVariable String idFactura){
        return this.service.findByIdFactura(idFactura);
    }
}
