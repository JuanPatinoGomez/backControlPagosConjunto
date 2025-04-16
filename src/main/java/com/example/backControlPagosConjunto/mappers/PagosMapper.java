package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.models.PagosDTO;
import com.example.backControlPagosConjunto.models.Pagos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PagosMapper  extends GenericMapper<Pagos, PagosDTO>{
}
