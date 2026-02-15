package com.example.backControlPagosConjunto.services;

import java.util.UUID;

import com.example.backControlPagosConjunto.dtos.models.UsuariosDTO;
import com.example.backControlPagosConjunto.models.Usuarios;

public interface UsuariosService extends BaseService<UsuariosDTO, UUID>{
    // Aquí puedes agregar métodos específicos para el modelo

    Boolean validarLogin(String usuario, String password);
    UsuariosDTO findByUsuario(String usuario);
}
