package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.models.DetallesFacturasDTO;
import com.example.backControlPagosConjunto.models.DetallesFacturas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetallesFacturasMapper extends GenericMapper<DetallesFacturas, DetallesFacturasDTO>{

    @Override
    @Mapping(target = "servicio", source = "servicio.nombre")
    @Mapping(target = "codigoServicio", source = "servicio.codigo")
    @Mapping(target = "descripcionServicio", source = "servicio.descripcion")
    DetallesFacturasDTO toDTO(DetallesFacturas detallesFacturas);

    @Override
    @Mapping(target = "servicio", ignore = true)
    DetallesFacturas toEntity(DetallesFacturasDTO entity);


    @Override
    List<DetallesFacturasDTO> toDTOList(List<DetallesFacturas> detallesFacturasList);
}
