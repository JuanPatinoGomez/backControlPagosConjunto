package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.models.MetodosPagos;
import com.example.backControlPagosConjunto.services.MetodosPagosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/metodosPagos")
public class MetodosPagosController extends BaseController<MetodosPagos, String>{


    public MetodosPagosController(MetodosPagosService service) {
        super(service);
    }

    //Metodos adicionales
}
