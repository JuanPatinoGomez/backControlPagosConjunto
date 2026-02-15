package com.example.backControlPagosConjunto.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "pagos")
@Data
public class Pagos {

    @Column(name = "id", insertable = false, nullable = false, updatable = false)
    private Integer id;

    @Id
    @UuidGenerator
    @Column(name = "id_pago", nullable = false)
    private UUID idPago;

    @Column(name = "id_factura", nullable = false)
    private UUID idFactura;

    @Column(name = "id_residente", nullable = false)
    private UUID idResidente;

    @Column(name = "fecha_pago" , nullable = false)
    private LocalDateTime fechaPago;

    @Column(name = "monto", nullable = false)
    private Long monto;

    @Column(name = "id_metodo_pago", nullable = false)
    private UUID idMetodoPago;
}
