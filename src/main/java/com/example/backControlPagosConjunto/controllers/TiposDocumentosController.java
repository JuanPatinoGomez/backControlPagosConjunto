package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.models.TiposDocumentos;
import com.example.backControlPagosConjunto.services.TiposDocumentosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tiposDocumentos")
public class TiposDocumentosController extends BaseController<TiposDocumentos, String>{

    public TiposDocumentosController(TiposDocumentosService service) {
        super(service);
    }

    //Metodos adicionales
}
