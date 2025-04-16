package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.models.TiposDocumentosDTO;
import com.example.backControlPagosConjunto.models.TiposDocumentos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TiposDocumentosMapper extends GenericMapper<TiposDocumentos, TiposDocumentosDTO>{
}
