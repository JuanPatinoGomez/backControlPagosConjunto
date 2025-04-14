package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.models.ResidentesDTO;
import com.example.backControlPagosConjunto.models.Residentes;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResidentesMapper {

    ResidentesDTO toDTO(Residentes residentes);
    List<ResidentesDTO> toDTOList(List<Residentes> residentesList);
}
