package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.models.DetallesFacturasDTO;
import com.example.backControlPagosConjunto.services.DetallesFacturasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/detallesFacturas")
public class DetallesFacturasController extends BaseController<DetallesFacturasDTO, UUID>{

    private final DetallesFacturasService service;

    public DetallesFacturasController(DetallesFacturasService service) {
        super(service);
        this.service = service;
    }

    //Metodos adicionales
    @GetMapping("/factura/{idFactura}")
    public List<DetallesFacturasDTO> getFactura(@PathVariable UUID idFactura){
        return this.service.findByIdFactura(idFactura);
    }
}
