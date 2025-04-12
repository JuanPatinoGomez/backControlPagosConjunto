package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.models.Residentes;
import com.example.backControlPagosConjunto.repositories.ResidentesRepository;
import com.example.backControlPagosConjunto.services.ResidentesService;
import org.springframework.stereotype.Service;

@Service
public class ResidentesServiceImpl extends BaseServiceImpl<Residentes, String> implements ResidentesService {

    public ResidentesServiceImpl(ResidentesRepository repository) {
        super(repository);
    }

}
