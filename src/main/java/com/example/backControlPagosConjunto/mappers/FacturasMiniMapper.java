package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.dtos.models.custom.FacturasMiniDTO;
import com.example.backControlPagosConjunto.models.Facturas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacturasMiniMapper extends GenericMapper<Facturas, FacturasMiniDTO>{

    @Override
    @Mapping(target = "nombreResidente", source = "residente.nombreCompleto")
    FacturasMiniDTO toDTO(Facturas facturas);
    @Override
    List<FacturasMiniDTO> toDTOList(List<Facturas> facturasList);
}
