package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.models.TiposViviendasDTO;
import com.example.backControlPagosConjunto.mappers.TiposViviendasMapper;
import com.example.backControlPagosConjunto.models.TiposViviendas;
import com.example.backControlPagosConjunto.repositories.TiposViviendasRepository;
import com.example.backControlPagosConjunto.services.TiposViviendasService;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TiposViviendasServiceImpl extends BaseServiceImpl<TiposViviendas, TiposViviendasDTO, UUID> implements TiposViviendasService {

    public TiposViviendasServiceImpl(TiposViviendasRepository repository, TiposViviendasMapper mapper) {
        super(repository, mapper);
    }

}
