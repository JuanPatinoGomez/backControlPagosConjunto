package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.models.MetodosPagosDTO;
import com.example.backControlPagosConjunto.mappers.MetodosPagosMapper;
import com.example.backControlPagosConjunto.models.MetodosPagos;
import com.example.backControlPagosConjunto.repositories.MetodosPagosRepository;
import com.example.backControlPagosConjunto.services.MetodosPagosService;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class MetodosPagosServiceImpl extends BaseServiceImpl<MetodosPagos, MetodosPagosDTO , UUID> implements MetodosPagosService {

    private final MetodosPagosRepository repository;
    private final MetodosPagosMapper mapper;

    public MetodosPagosServiceImpl(MetodosPagosRepository repository, MetodosPagosRepository repository1, MetodosPagosMapper mapper) {
        super(repository, mapper);
        this.repository = repository1;
        this.mapper = mapper;
    }

    @Override
    public MetodosPagosDTO findByCodigo(String codigo) {
        return this.mapper.toDTO(this.repository.findByCodigo(codigo));
    }
}
