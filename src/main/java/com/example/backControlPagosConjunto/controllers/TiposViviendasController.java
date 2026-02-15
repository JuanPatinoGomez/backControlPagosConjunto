package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.models.TiposViviendasDTO;
import com.example.backControlPagosConjunto.services.TiposViviendasService;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tiposViviendas")
public class TiposViviendasController extends BaseController<TiposViviendasDTO, UUID>{
    public TiposViviendasController(TiposViviendasService service) {
        super(service);
    }

    //Metodos adicionales
}
