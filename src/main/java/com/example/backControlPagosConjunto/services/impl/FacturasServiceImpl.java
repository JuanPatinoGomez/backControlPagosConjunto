package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.dtos.operatives.FacturasFilterDTO;
import com.example.backControlPagosConjunto.mappers.FacturasMapper;
import com.example.backControlPagosConjunto.models.Facturas;
import com.example.backControlPagosConjunto.repositories.FacturasRepository;
import com.example.backControlPagosConjunto.services.FacturasService;
import com.example.backControlPagosConjunto.specifications.FacturasSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturasServiceImpl extends BaseServiceImpl<Facturas, FacturasDTO, String> implements FacturasService {

    private final FacturasRepository repository;
    private final FacturasMapper mapper;

    public FacturasServiceImpl(FacturasRepository repository, FacturasMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<Facturas> findAllWithFilters(FacturasFilterDTO filterDTO) {
        Pageable pageable = PageRequest.of(filterDTO.getPagina(), filterDTO.getCantidad(), Sort.by(Sort.Direction.DESC, "fechaVencimiento"));

        Specification<Facturas> spec = Specification.where(null);

        if(filterDTO.getIdResidente() != null && !filterDTO.getIdResidente().isBlank()) {
            spec = spec.and(FacturasSpecifications.facturasPorIdResidente(filterDTO.getIdResidente()));
        }

        if(filterDTO.getNombre() != null && !filterDTO.getNombre().isBlank()) {
            spec = spec.and(FacturasSpecifications.facturasPorNombreResidente(filterDTO.getNombre()));
        }

        //Parte or estado
        Specification<Facturas> filtrosOr = Specification.where(null);

        if(filterDTO.isIndicadorAlDia()) {
            filtrosOr = filtrosOr.or(FacturasSpecifications.facturasAlDia());
        }

        if(filterDTO.isIndicadorPendientes()) {
            filtrosOr = filtrosOr.or(FacturasSpecifications.facturasPendientes());
        }

        if(filterDTO.isIndicadorMora()) {
            filtrosOr = filtrosOr.or(FacturasSpecifications.facturasEnMora());
        }

        spec = spec.and(filtrosOr);

        return repository.findAll(spec, pageable);
    }
}
