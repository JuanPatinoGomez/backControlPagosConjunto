package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.operatives.FacturasFilterDTO;
import com.example.backControlPagosConjunto.models.Facturas;
import com.example.backControlPagosConjunto.services.FacturasService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturasController extends BaseController<Facturas, String>{

    private final FacturasService service;

    public FacturasController(FacturasService service) {
        super(service);
        this.service = service;
    }

    //Metodos adicionales

    @PostMapping("/search/all/filters")
    public Page<Facturas> findAllWithFilters(@RequestBody FacturasFilterDTO filterDTO){
        return service.findAllWithFilters(filterDTO);
    }
}
