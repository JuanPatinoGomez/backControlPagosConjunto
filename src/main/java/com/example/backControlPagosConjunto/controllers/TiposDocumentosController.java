package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.models.TiposDocumentosDTO;
import com.example.backControlPagosConjunto.services.TiposDocumentosService;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tiposDocumentos")
public class TiposDocumentosController extends BaseController<TiposDocumentosDTO, UUID>{

    public TiposDocumentosController(TiposDocumentosService service) {
        super(service);
    }

    //Metodos adicionales
}
