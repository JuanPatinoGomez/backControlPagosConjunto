package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.models.PagosDTO;
import com.example.backControlPagosConjunto.services.PagosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pagos")
public class PagosController extends BaseController<PagosDTO, UUID>{

    private final PagosService service;

    public PagosController(PagosService service) {
        super(service);
        this.service = service;
    }

    //Metodos adicionales
    @GetMapping("/factura/{idFactura}")
    public List<PagosDTO> findByIdFactura(@PathVariable UUID idFactura){
        return service.findByIdFactura(idFactura);
    }
}
