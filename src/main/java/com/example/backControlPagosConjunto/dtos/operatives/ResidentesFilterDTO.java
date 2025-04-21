package com.example.backControlPagosConjunto.dtos.operatives;

import lombok.Data;

@Data
public class ResidentesFilterDTO {
    private String idResidente;
    private String nombre;
    private boolean indicadorAlDia;
    private boolean indicadorPendientes;
    private boolean indicadorMora;
}
