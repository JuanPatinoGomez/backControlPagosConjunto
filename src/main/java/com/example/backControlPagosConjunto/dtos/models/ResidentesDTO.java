package com.example.backControlPagosConjunto.dtos.models;


import com.example.backControlPagosConjunto.models.Facturas;
import lombok.Data;

import java.util.List;

@Data
public class ResidentesDTO {

    private Integer id;
    private String idResidente;
    private String idTipoDocumento;
    private String numeroDocumento;
    private String nombreCompleto;
    private String numeroVivienda;
    private String idTipoVivienda;

    private String tipoDocumento;;
    private String codigoTipoDocumento;

    private String tipoVivienda;
    private String codigoTipoVivienda;

    //Campo calculado
    private String numEstado;

}
