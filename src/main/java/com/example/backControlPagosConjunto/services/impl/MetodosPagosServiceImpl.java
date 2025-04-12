package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.models.MetodosPagos;
import com.example.backControlPagosConjunto.repositories.MetodosPagosRepository;
import com.example.backControlPagosConjunto.services.MetodosPagosService;
import org.springframework.stereotype.Service;

@Service
public class MetodosPagosServiceImpl extends BaseServiceImpl<MetodosPagos, String> implements MetodosPagosService {

    public MetodosPagosServiceImpl(MetodosPagosRepository repository) {
        super(repository);
    }

}
