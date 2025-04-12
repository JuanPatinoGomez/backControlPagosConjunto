package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.models.Servicios;
import com.example.backControlPagosConjunto.services.ServiciosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servicios")
public class ServiciosController extends BaseController<Servicios, String>{

    public ServiciosController(ServiciosService service) {
        super(service);
    }

    //Metodos adicionales
}
