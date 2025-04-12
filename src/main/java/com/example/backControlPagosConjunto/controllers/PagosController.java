package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.models.Pagos;
import com.example.backControlPagosConjunto.services.PagosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagos")
public class PagosController extends BaseController<Pagos, String>{


    public PagosController(PagosService service) {
        super(service);
    }

    //Metodos adicionales
}
