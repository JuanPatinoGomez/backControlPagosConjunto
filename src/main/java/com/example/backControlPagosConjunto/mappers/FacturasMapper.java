package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.models.Facturas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacturasMapper  extends GenericMapper<Facturas, FacturasDTO>{
    @Override
    @Mapping(target = "nombreResidente", source = "residente.nombreCompleto")
    @Mapping(target = "numeroDocumentoResidente", source = "residente.numeroDocumento")
    FacturasDTO toDTO(Facturas facturas);
    @Override
    List<FacturasDTO> toDTOList(List<Facturas> facturasList);
}
