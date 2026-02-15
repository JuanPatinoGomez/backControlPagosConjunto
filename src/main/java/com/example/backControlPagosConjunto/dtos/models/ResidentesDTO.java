package com.example.backControlPagosConjunto.dtos.models;


import com.example.backControlPagosConjunto.models.Facturas;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ResidentesDTO {

    private Integer id;
    private UUID idResidente;
    private UUID idTipoDocumento;
    private String numeroDocumento;
    private String nombreCompleto;
    private String numeroVivienda;
    private UUID idTipoVivienda;

    private String tipoDocumento;;
    private String codigoTipoDocumento;

    private String tipoVivienda;
    private String codigoTipoVivienda;

    //Campo calculado
    private String numEstado;

}
