package com.example.backControlPagosConjunto.dtos.general;

import lombok.Data;

@Data
public class GeneralSearchDTO {
    private String searchTerm;
    private Integer pagina;
    private Integer cantidad;
}
