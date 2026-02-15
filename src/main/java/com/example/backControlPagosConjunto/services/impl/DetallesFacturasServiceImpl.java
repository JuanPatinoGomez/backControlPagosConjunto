package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.models.DetallesFacturasDTO;
import com.example.backControlPagosConjunto.mappers.DetallesFacturasMapper;
import com.example.backControlPagosConjunto.models.DetallesFacturas;
import com.example.backControlPagosConjunto.repositories.DetallesFacturasRepository;
import com.example.backControlPagosConjunto.services.DetallesFacturasService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DetallesFacturasServiceImpl extends BaseServiceImpl<DetallesFacturas, DetallesFacturasDTO, UUID> implements DetallesFacturasService {

    private final DetallesFacturasRepository repository;
    private final DetallesFacturasMapper mapper;

    public DetallesFacturasServiceImpl(DetallesFacturasRepository repository, DetallesFacturasMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DetallesFacturasDTO> findByIdFactura(UUID idFactura) {
        List<DetallesFacturas> detallesFacturas = repository.findByIdFactura(idFactura);
        return this.mapper.toDTOList(detallesFacturas);
    }
}
