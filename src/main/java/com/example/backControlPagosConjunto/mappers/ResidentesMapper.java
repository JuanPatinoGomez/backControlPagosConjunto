package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.models.ResidentesDTO;
import com.example.backControlPagosConjunto.models.Residentes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResidentesMapper  extends GenericMapper<Residentes, ResidentesDTO>{
    @Override
    @Mapping(target = "tipoDocumento", source = "tipoDocumento.nombre")
    @Mapping(target = "codigoTipoDocumento", source = "tipoDocumento.codigo")
    @Mapping(target = "tipoVivienda", source = "tipoVivienda.nombre")
    @Mapping(target = "codigoTipoVivienda", source = "tipoVivienda.codigo")
    ResidentesDTO toDTO(Residentes residentes);

    @Override
    @Mapping(target = "tipoDocumento", ignore = true)
    @Mapping(target = "tipoVivienda", ignore = true)
    Residentes toEntity(ResidentesDTO residentesDTO);

    @Override
    List<ResidentesDTO> toDTOList(List<Residentes> residentesList);
}
