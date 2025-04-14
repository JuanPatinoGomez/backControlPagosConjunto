package com.example.backControlPagosConjunto.dtos.operatives;

import lombok.Data;

@Data
public class FacturasFilterDTO {

    private String nombre;
    private String idResidente;
    private boolean indicadorAlDia;
    private boolean indicadorPendientes;
    private boolean indicadorMora;
    private Integer pagina;
    private Integer cantidad;
}
