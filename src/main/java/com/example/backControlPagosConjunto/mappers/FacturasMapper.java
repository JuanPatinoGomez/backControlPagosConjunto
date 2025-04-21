package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.models.Facturas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FacturasMapper  extends GenericMapper<Facturas, FacturasDTO>{
    @Override
    @Mapping(target = "nombreResidente", source = "residente.nombreCompleto")
    @Mapping(target = "numeroDocumentoResidente", source = "residente.numeroDocumento")
    @Mapping(target = "numEstado", expression = "java(calcularNumEstado(facturas.getEstado(), facturas.getFechaVencimiento()))")
    FacturasDTO toDTO(Facturas facturas);
    @Override
    List<FacturasDTO> toDTOList(List<Facturas> facturasList);


    default String calcularNumEstado(Boolean indicadorEstado, LocalDateTime fechaVencimiento) {
        if(indicadorEstado) return "1";
        LocalDateTime fechaActual = LocalDateTime.now();
        if(fechaVencimiento.isAfter(fechaActual)) return "2";
        return "3";
    }
}
