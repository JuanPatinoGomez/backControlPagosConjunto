package com.example.backControlPagosConjunto.dtos.models;


import java.util.UUID;

import com.example.backControlPagosConjunto.models.BaseEntidad;
import lombok.Data;


@Data
public class TiposDocumentosDTO extends BaseModelDTO {

    private UUID idTipoDocumento;
}
