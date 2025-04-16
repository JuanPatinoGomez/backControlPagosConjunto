package com.example.backControlPagosConjunto.dtos.models;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
public class BaseModelDTO {

    private Integer id;
    private String codigo;
    private String nombre;

}
