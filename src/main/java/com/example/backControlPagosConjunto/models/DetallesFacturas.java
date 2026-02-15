package com.example.backControlPagosConjunto.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "detalles_facturas")
@Data
public class DetallesFacturas {

    @Column(name = "id", insertable = false, nullable = false, updatable = false)
    private Integer id;

    @Id
    @UuidGenerator
    @Column(name = "id_detalle_factura", nullable = false)
    private UUID idDetalleFactura;

    @Column(name = "id_factura", nullable = false)
    private UUID idFactura;

    @Column(name = "id_servicio", nullable = false)
    private UUID idServicio;

    @Column(name = "monto", nullable = false)
    private Long monto;

    @ManyToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", insertable = false, updatable = false)
    private Servicios servicio;
}
