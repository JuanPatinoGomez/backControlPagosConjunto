package com.example.backControlPagosConjunto.dtos.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Data
public class PagosDTO {
    private Integer id;
    private String idPago;
    private String idFactura;
    private String idResidente;
    private LocalDateTime fechaPago;
    private Long monto;
    private String idMetodoPago;
}
