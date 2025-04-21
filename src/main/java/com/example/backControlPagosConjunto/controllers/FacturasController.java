package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.general.GeneralFilterDTO;
import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.dtos.models.custom.FacturasMiniDTO;
import com.example.backControlPagosConjunto.dtos.operatives.FacturasFilterDTO;
import com.example.backControlPagosConjunto.services.FacturasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<FacturasDTO> findAllWithFilters(@RequestBody FacturasFilterDTO filterDTO){
        return service.findAllWithFilters(filterDTO);
    }

    @PostMapping("/search/nombreResidente/codigo")
    public List<FacturasMiniDTO> findAllbynombreResidenteORcodigo(@RequestBody GeneralFilterDTO filterDTO){
        return service.findAllbynombreResidenteORcodigo(filterDTO);
    }
}
