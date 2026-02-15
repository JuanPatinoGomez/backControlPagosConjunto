package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.models.ServiciosDTO;
import com.example.backControlPagosConjunto.services.ServiciosService;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servicios")
public class ServiciosController extends BaseController<ServiciosDTO, UUID>{

    public ServiciosController(ServiciosService service) {
        super(service);
    }

    //Metodos adicionales
}
