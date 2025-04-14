package com.example.backControlPagosConjunto.dtos.models;


import lombok.Data;

@Data
public class ResidentesDTO {

    private Integer id;
    private String idResidente;
    private String idTipoDocumento;
    private String numeroDocumento;
    private String nombreCompleto;
    private String numeroVivienda;
    private String idTipoVivienda;

}
