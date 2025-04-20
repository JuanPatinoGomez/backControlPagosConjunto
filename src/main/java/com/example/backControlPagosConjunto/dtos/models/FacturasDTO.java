package com.example.backControlPagosConjunto.dtos.models;


import com.example.backControlPagosConjunto.models.Residentes;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Data
public class FacturasDTO {

    private Integer id;
    private String idFactura;
    private String idResidente;
    private LocalDateTime fechaEmision;
    private LocalDateTime fechaVencimiento;
    private Long total;
    private String codigo;
    private Boolean estado;
    private String nombreResidente;
    private String numeroDocumentoResidente;


}
