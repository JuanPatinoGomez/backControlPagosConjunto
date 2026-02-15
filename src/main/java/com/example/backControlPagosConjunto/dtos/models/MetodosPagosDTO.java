package com.example.backControlPagosConjunto.dtos.models;


import com.example.backControlPagosConjunto.models.BaseEntidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;


@Data
public class MetodosPagosDTO extends BaseModelDTO {

    private UUID idMetodoPago;
}
