package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.dtos.operatives.FacturasFilterDTO;
import com.example.backControlPagosConjunto.services.FacturasService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facturas")
public class FacturasController extends BaseController<FacturasDTO, String>{

    private final FacturasService service;

    public FacturasController(FacturasService service) {
        super(service);
        this.service = service;
    }

    //Metodos adicionales

    @PostMapping("/search/all/filters")
    public Page<FacturasDTO> findAllWithFilters(@RequestBody FacturasFilterDTO filterDTO){
        return service.findAllWithFilters(filterDTO);
    }
}
