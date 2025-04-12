package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.models.Facturas;
import com.example.backControlPagosConjunto.repositories.FacturasRepository;
import com.example.backControlPagosConjunto.services.FacturasService;
import org.springframework.stereotype.Service;

@Service
public class FacturasServiceImpl extends BaseServiceImpl<Facturas, String> implements FacturasService {

    public FacturasServiceImpl(FacturasRepository repository) {
        super(repository);
    }

}
