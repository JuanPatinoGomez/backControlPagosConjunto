package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.models.TiposDocumentos;
import com.example.backControlPagosConjunto.repositories.TiposDocumentosRepository;
import com.example.backControlPagosConjunto.services.TiposDocumentosService;
import org.springframework.stereotype.Service;

@Service
public class TiposDocumentosServiceImpl extends BaseServiceImpl<TiposDocumentos, String> implements TiposDocumentosService {

    public TiposDocumentosServiceImpl(TiposDocumentosRepository repository) {
        super(repository);
    }

}
