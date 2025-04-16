package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.models.MetodosPagosDTO;
import com.example.backControlPagosConjunto.mappers.MetodosPagosMapper;
import com.example.backControlPagosConjunto.models.MetodosPagos;
import com.example.backControlPagosConjunto.repositories.MetodosPagosRepository;
import com.example.backControlPagosConjunto.services.MetodosPagosService;
import org.springframework.stereotype.Service;

@Service
public class MetodosPagosServiceImpl extends BaseServiceImpl<MetodosPagos, MetodosPagosDTO ,String> implements MetodosPagosService {

    private final MetodosPagosMapper mapper;

    public MetodosPagosServiceImpl(MetodosPagosRepository repository, MetodosPagosMapper mapper) {
        super(repository, mapper);
        this.mapper = mapper;
    }

}
