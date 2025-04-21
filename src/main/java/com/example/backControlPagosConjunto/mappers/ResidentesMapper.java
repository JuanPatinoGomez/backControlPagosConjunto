package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.models.ResidentesDTO;
import com.example.backControlPagosConjunto.models.Facturas;
import com.example.backControlPagosConjunto.models.Residentes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {FacturasMapper.class})
public interface ResidentesMapper  extends GenericMapper<Residentes, ResidentesDTO>{

    @Override
    @Mapping(target = "tipoDocumento", source = "tipoDocumento.nombre")
    @Mapping(target = "codigoTipoDocumento", source = "tipoDocumento.codigo")
    @Mapping(target = "tipoVivienda", source = "tipoVivienda.nombre")
    @Mapping(target = "codigoTipoVivienda", source = "tipoVivienda.codigo")
    @Mapping(target = "numEstado", expression = "java(calcularNumEstadoResidente(residentes.getFacturasList(), null))")
    ResidentesDTO toDTO(Residentes residentes);

    @Mapping(target = "tipoDocumento", source = "residentes.tipoDocumento.nombre")
    @Mapping(target = "codigoTipoDocumento", source = "residentes.tipoDocumento.codigo")
    @Mapping(target = "tipoVivienda", source = "residentes.tipoVivienda.nombre")
    @Mapping(target = "codigoTipoVivienda", source = "residentes.tipoVivienda.codigo")
    @Mapping(target = "numEstado", expression = "java(calcularNumEstadoResidente(residentes.getFacturasList(), filtroEstado))")
    ResidentesDTO toDTO(Residentes residentes, List<String> filtroEstado);

    @Override
    @Mapping(target = "tipoDocumento", ignore = true)
    @Mapping(target = "tipoVivienda", ignore = true)
    @Mapping(target = "facturasList", ignore = true)
    Residentes toEntity(ResidentesDTO residentesDTO);

    @Override
    List<ResidentesDTO> toDTOList(List<Residentes> residentesList);


    default String calcularNumEstadoResidente(List<Facturas> facturas, List<String> filtroEstado) {

        if (facturas == null || facturas.isEmpty()) return "0";

        List<String> listadoDeEstados = facturas.stream().map(f -> calcularNumEstadoFactura(f.getEstado(), f.getFechaVencimiento())).filter(e -> filtroEstado == null || filtroEstado.isEmpty() || filtroEstado.contains(e)).sorted().toList().reversed();

        return listadoDeEstados.getFirst();
    }

    default String calcularNumEstadoFactura(Boolean indicadorEstado, LocalDateTime fechaVencimiento) {
        if(indicadorEstado) return "1";
        LocalDateTime fechaActual = LocalDateTime.now();
        if(fechaVencimiento.isAfter(fechaActual)) return "2";
        return "3";
    }

}
