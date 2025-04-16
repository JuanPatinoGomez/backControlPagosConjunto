package com.example.backControlPagosConjunto.mappers;

import java.util.List;

public interface GenericMapper<ENTITY, DTO> {

    DTO toDTO(ENTITY entity);
    ENTITY toEntity(DTO entity);
    List<DTO> toDTOList(List<ENTITY> entityList);
}
