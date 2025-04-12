package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.models.Pagos;
import com.example.backControlPagosConjunto.repositories.PagosRepository;
import com.example.backControlPagosConjunto.services.PagosService;
import org.springframework.stereotype.Service;

@Service
public class PagosServiceImpl extends BaseServiceImpl<Pagos, String> implements PagosService {

    public PagosServiceImpl(PagosRepository repository) {
        super(repository);
    }

}
