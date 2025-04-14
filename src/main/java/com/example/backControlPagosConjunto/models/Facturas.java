package com.example.backControlPagosConjunto.models;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Data
public class Facturas {

    @Column(name = "id", insertable = false, nullable = false, updatable = false)
    private Integer id;

    @Id
    @UuidGenerator
    @Column(name = "id_factura", nullable = false)
    private String idFactura;

    @Column(name = "id_residente" , nullable = false)
    private String idResidente;

    @Column(name = "fecha_emision" , nullable = false)
    private LocalDateTime fechaEmision;
    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDateTime fechaVencimiento;
    @Column(name = "total", nullable = false)
    private Long total;
    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_residente", referencedColumnName = "id_residente", insertable = false, updatable = false)
    private Residentes residente;


}
