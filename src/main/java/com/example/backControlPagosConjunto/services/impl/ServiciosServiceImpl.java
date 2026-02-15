package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.models.ServiciosDTO;
import com.example.backControlPagosConjunto.mappers.ServiciosMapper;
import com.example.backControlPagosConjunto.models.Servicios;
import com.example.backControlPagosConjunto.repositories.ServiciosRepository;
import com.example.backControlPagosConjunto.services.ServiciosService;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ServiciosServiceImpl extends BaseServiceImpl<Servicios, ServiciosDTO, UUID> implements ServiciosService {

    private final ServiciosMapper mapper;

    public ServiciosServiceImpl(ServiciosRepository repository, ServiciosMapper mapper) {
        super(repository, mapper);
        this.mapper = mapper;
    }

}
