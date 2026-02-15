package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.models.MetodosPagosDTO;
import com.example.backControlPagosConjunto.services.MetodosPagosService;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/metodosPagos")
public class MetodosPagosController extends BaseController<MetodosPagosDTO, UUID>{


    public MetodosPagosController(MetodosPagosService service) {
        super(service);
    }

    //Metodos adicionales
}
