package com.example.backControlPagosConjunto.models;


import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntidad {

    @Column(name = "id", insertable = false, nullable = false, updatable = false)
    private Integer id;
    @Column(name = "codigo", nullable = false)
    private String codigo;
    @Column(name = "nombre", nullable = false)
    private String nombre;

}
