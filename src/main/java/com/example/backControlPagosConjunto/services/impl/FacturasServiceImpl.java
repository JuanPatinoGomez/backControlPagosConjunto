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
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
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
    public FacturasDTO save(FacturasDTO dto){
        Facturas factura = mapper.toEntity(dto);
        factura.setCodigo(generarCodigoSeguro());
        Facturas saved = repository.save(factura);
        return mapper.toDTO(saved);
    }

    private String generarCodigoSeguro() {
        String input = LocalDateTime.now().toString() + Math.random();
        String hash = DigestUtils.md5DigestAsHex(input.getBytes()).substring(0, 10).toUpperCase();
        return "FCT-" + hash;
    }

    @Override
    public Page<FacturasDTO> findAllWithFilters(FacturasFilterDTO filterDTO) {
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

        Page<Facturas> facturasPage = repository.findAll(spec, pageable);

        return facturasPage.map(mapper::toDTO);

    }
}
