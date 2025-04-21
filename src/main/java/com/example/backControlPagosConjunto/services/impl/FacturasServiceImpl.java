package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.general.GeneralFilterDTO;
import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.dtos.models.custom.FacturasMiniDTO;
import com.example.backControlPagosConjunto.dtos.operatives.FacturasFilterDTO;
import com.example.backControlPagosConjunto.mappers.FacturasMapper;
import com.example.backControlPagosConjunto.mappers.FacturasMiniMapper;
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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturasServiceImpl extends BaseServiceImpl<Facturas, FacturasDTO, String> implements FacturasService {

    private final FacturasRepository repository;
    private final FacturasMapper mapper;
    private final FacturasMiniMapper miniMapper;

    public FacturasServiceImpl(FacturasRepository repository, FacturasMapper mapper, FacturasMiniMapper miniMapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.miniMapper = miniMapper;
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
    public List<FacturasDTO> findAllWithFilters(FacturasFilterDTO filterDTO) {
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

        List<Facturas> facturasList = repository.findAll(spec, Sort.by(Sort.Direction.DESC, "fechaVencimiento"));

        return mapper.toDTOList(facturasList);

    }

    @Override
    public List<FacturasMiniDTO> findAllbynombreResidenteORcodigo(GeneralFilterDTO filterDTO) {
        Specification<Facturas> spec = Specification.where(null);

        if(filterDTO.getSearchTerm() != null && !filterDTO.getSearchTerm().isBlank()) {
            spec = spec.or(FacturasSpecifications.facturasPorNombreResidente(filterDTO.getSearchTerm()));
            spec = spec.or(FacturasSpecifications.facturasPorCodigoFactura(filterDTO.getSearchTerm()));
        }
        List<Facturas> facturasList = repository.findAll(spec, Sort.by(Sort.Direction.DESC, "fechaVencimiento"));

        List<Facturas> facturasUnicas = facturasList.stream()
                .collect(Collectors.groupingBy(
                        f -> f.getResidente().getId(), // Agrupamos por idResidente
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                lista -> lista.get(0) // Tomamos la primera factura de cada grupo
                        )
                ))
                .values()
                .stream()
                .toList();

        List<FacturasMiniDTO> facturasMiniDTOList = miniMapper.toDTOList(facturasUnicas);
        facturasMiniDTOList.sort(Comparator.comparing(FacturasMiniDTO::getNombreResidente));
        return facturasMiniDTOList;
    }
}
