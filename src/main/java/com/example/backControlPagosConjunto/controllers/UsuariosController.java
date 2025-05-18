package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.models.UsuariosDTO;
import com.example.backControlPagosConjunto.services.UsuariosService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController extends BaseController<UsuariosDTO, String>{

    private final UsuariosService service;
    public UsuariosController(UsuariosService service, UsuariosService service1) {
        super(service);
        this.service = service1;
    }

    //Metodos adicionales

    @PostMapping("/validarLogin")
    public Boolean validarLogin(@RequestBody UsuariosDTO usuariosDTO){
        return this.service.validarLogin(usuariosDTO.getUsuario(), usuariosDTO.getContrasena());
    }
}
