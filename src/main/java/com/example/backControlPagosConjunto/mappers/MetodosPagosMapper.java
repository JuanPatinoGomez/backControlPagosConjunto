package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.models.MetodosPagosDTO;
import com.example.backControlPagosConjunto.models.MetodosPagos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MetodosPagosMapper  extends GenericMapper<MetodosPagos, MetodosPagosDTO> {

}
