package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.models.TiposViviendasDTO;
import com.example.backControlPagosConjunto.models.TiposViviendas;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TiposViviendasMapper extends GenericMapper<TiposViviendas, TiposViviendasDTO>{
}
