package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.models.TiposViviendas;
import com.example.backControlPagosConjunto.services.TiposViviendasService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tiposViviendas")
public class TiposViviendasController extends BaseController<TiposViviendas, String>{
    public TiposViviendasController(TiposViviendasService service) {
        super(service);
    }

    //Metodos adicionales
}
