package com.example.backControlPagosConjunto.dtos;

import lombok.Data;

@Data
public class DetallesFacturasDTO {

    private Integer id;
    private String idDetalleFactura;
    private String idFactura;
    private String idServicio;
    private Long monto;

    private String servicio;
    private String codigoServicio;
    private String descripcionServicio;

}
