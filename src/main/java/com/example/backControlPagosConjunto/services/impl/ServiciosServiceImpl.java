package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.models.Servicios;
import com.example.backControlPagosConjunto.repositories.ServiciosRepository;
import com.example.backControlPagosConjunto.services.ServiciosService;
import org.springframework.stereotype.Service;

@Service
public class ServiciosServiceImpl extends BaseServiceImpl<Servicios, String> implements ServiciosService {

    public ServiciosServiceImpl(ServiciosRepository repository) {
        super(repository);
    }

}
