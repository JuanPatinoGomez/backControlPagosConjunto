package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.DetallesFacturasDTO;
import com.example.backControlPagosConjunto.models.DetallesFacturas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetallesFacturasMapper {
    @Mapping(target = "servicio", source = "servicio.nombre")
    @Mapping(target = "codigoServicio", source = "servicio.codigo")
    @Mapping(target = "descripcionServicio", source = "servicio.descripcion")
    DetallesFacturasDTO toDTO(DetallesFacturas detallesFacturas);
    List<DetallesFacturasDTO> toDTOList(List<DetallesFacturas> detallesFacturasList);
}
