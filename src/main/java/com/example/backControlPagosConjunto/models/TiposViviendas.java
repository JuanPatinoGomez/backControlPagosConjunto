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
@Table(name = "tipos_viviendas")
@Data
@EqualsAndHashCode(callSuper = true)
public class TiposViviendas extends BaseEntidad{

    @Id
    @UuidGenerator
    @Column(name = "id_tipo_vivienda", nullable = false)
    private UUID idTipoVivienda;
}
