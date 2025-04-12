package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.models.Residentes;
import com.example.backControlPagosConjunto.models.Servicios;
import com.example.backControlPagosConjunto.services.ResidentesService;
import com.example.backControlPagosConjunto.services.ServiciosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/residentes")
public class ResidentesController extends BaseController<Residentes, String>{

    private final ResidentesService residentesService;

    public ResidentesController(ResidentesService service) {
        super(service);
        this.residentesService = service;
    }

    //Metodos adicionales


    //todo: Servicio para buscar por nombre


    //todo: Servicio con paginador de residentes
}
