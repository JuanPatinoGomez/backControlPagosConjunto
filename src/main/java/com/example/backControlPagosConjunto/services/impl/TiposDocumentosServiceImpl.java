package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.models.TiposDocumentosDTO;
import com.example.backControlPagosConjunto.mappers.TiposDocumentosMapper;
import com.example.backControlPagosConjunto.models.TiposDocumentos;
import com.example.backControlPagosConjunto.repositories.TiposDocumentosRepository;
import com.example.backControlPagosConjunto.services.TiposDocumentosService;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TiposDocumentosServiceImpl extends BaseServiceImpl<TiposDocumentos, TiposDocumentosDTO, UUID> implements TiposDocumentosService {

    public TiposDocumentosServiceImpl(TiposDocumentosRepository repository, TiposDocumentosMapper mapper) {
        super(repository, mapper);
    }

}
