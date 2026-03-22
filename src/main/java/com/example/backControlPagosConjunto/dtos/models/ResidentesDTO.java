package com.example.backControlPagosConjunto.dtos.models;


import com.example.backControlPagosConjunto.models.Facturas;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidentesDTO {

    private Integer id;
    private UUID idResidente;
    private UUID idTipoDocumento;
    @NotEmpty
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
