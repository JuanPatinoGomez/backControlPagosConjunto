package com.example.backControlPagosConjunto.dtos.models;

import java.util.UUID;

import lombok.Data;

@Data
public class DetallesFacturasDTO {

    private Integer id;
    private UUID idDetalleFactura;
    private UUID idFactura;
    private UUID idServicio;
    private Long monto;

    private String servicio;
    private String codigoServicio;
    private String descripcionServicio;

}
