package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.models.ServiciosDTO;
import com.example.backControlPagosConjunto.models.Servicios;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiciosMapper extends GenericMapper<Servicios, ServiciosDTO>{
}
