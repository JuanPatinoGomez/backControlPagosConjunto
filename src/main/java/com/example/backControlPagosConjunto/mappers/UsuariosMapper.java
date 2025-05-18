package com.example.backControlPagosConjunto.mappers;

import com.example.backControlPagosConjunto.dtos.models.UsuariosDTO;
import com.example.backControlPagosConjunto.models.Usuarios;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuariosMapper extends GenericMapper<Usuarios, UsuariosDTO>{
}
