package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.models.TiposViviendas;
import com.example.backControlPagosConjunto.repositories.TiposViviendasRepository;
import com.example.backControlPagosConjunto.services.TiposViviendasService;
import org.springframework.stereotype.Service;

@Service
public class TiposViviendasServiceImpl extends BaseServiceImpl<TiposViviendas, String> implements TiposViviendasService {

    public TiposViviendasServiceImpl(TiposViviendasRepository repository) {
        super(repository);
    }

}
