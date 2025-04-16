package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.models.MetodosPagosDTO;
import com.example.backControlPagosConjunto.services.MetodosPagosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/metodosPagos")
public class MetodosPagosController extends BaseController<MetodosPagosDTO, String>{


    public MetodosPagosController(MetodosPagosService service) {
        super(service);
    }

    //Metodos adicionales
}
