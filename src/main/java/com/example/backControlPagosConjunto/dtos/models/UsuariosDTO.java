package com.example.backControlPagosConjunto.dtos.models;

import java.util.UUID;

import lombok.Data;

@Data

public class UsuariosDTO {

    private Integer id;
    private UUID idUsuario;
    private String usuario;
    private String contrasena;

}
