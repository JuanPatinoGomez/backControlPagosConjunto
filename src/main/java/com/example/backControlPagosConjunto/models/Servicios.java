package com.example.backControlPagosConjunto.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "servicios")
@Data
@EqualsAndHashCode(callSuper = true)
public class Servicios extends BaseEntidad{

    @Id
    @UuidGenerator
    @Column(name = "id_servicio", nullable = false)
    private UUID idServicio;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo", nullable = false)
    private Long costo;
}
