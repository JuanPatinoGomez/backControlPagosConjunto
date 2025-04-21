package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.models.ResidentesDTO;
import com.example.backControlPagosConjunto.dtos.general.GeneralSearchDTO;
import com.example.backControlPagosConjunto.dtos.operatives.ResidentesFilterDTO;
import com.example.backControlPagosConjunto.mappers.ResidentesMapper;
import com.example.backControlPagosConjunto.models.Residentes;
import com.example.backControlPagosConjunto.repositories.ResidentesRepository;
import com.example.backControlPagosConjunto.services.ResidentesService;
import com.example.backControlPagosConjunto.specifications.ResidentesSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResidentesServiceImpl extends BaseServiceImpl<Residentes, ResidentesDTO, String> implements ResidentesService {

    private final ResidentesRepository repository;
    private final ResidentesMapper mapper;

    public ResidentesServiceImpl(ResidentesRepository repository, ResidentesMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ResidentesDTO> findAllByNombreCompletoContainingIgnoreCaseOrderByNombreCompletoAsc(String nombre) {
        return this.mapper.toDTOList(repository.findAllByNombreCompletoContainingIgnoreCaseOrderByNombreCompletoAsc(nombre));
    }

    @Override
    public Page<ResidentesDTO> findAllByNombreCompletoContainingIgnoreCase(GeneralSearchDTO search) {
        Pageable pageable = PageRequest.of(search.getPagina(), search.getCantidad(), Sort.by(Sort.Direction.ASC, "nombreCompleto"));
        return repository.findAllByNombreCompletoContainingIgnoreCase(search.getSearchTerm(), pageable).map(mapper::toDTO);
    }

    @Override
    public List<ResidentesDTO> findAllWithFilters(ResidentesFilterDTO filterDTO) {
        Specification<Residentes> spec = Specification.where(null);

        if (filterDTO.getIdResidente() != null && !filterDTO.getIdResidente().isBlank()) {
            spec = spec.and(ResidentesSpecifications.residentePorIdResidente(filterDTO.getIdResidente()));
        }

        if (filterDTO.getNombre() != null && !filterDTO.getNombre().isBlank()) {
            spec = spec.and(ResidentesSpecifications.residentePorNombre(filterDTO.getNombre()));
        }

        // Parte con estado de factura
        Specification<Residentes> filtrosOr = Specification.where(null);
        List<String> filtroIndicador = new ArrayList<>();

        if (filterDTO.isIndicadorAlDia()) {
            filtrosOr = filtrosOr.or(ResidentesSpecifications.residenteConFacturasAlDia());
            filtroIndicador.add("1");
        }

        if (filterDTO.isIndicadorPendientes()) {
            filtrosOr = filtrosOr.or(ResidentesSpecifications.residenteConFacturasPendientes());
            filtroIndicador.add("2");
        }

        if (filterDTO.isIndicadorMora()) {
            filtrosOr = filtrosOr.or(ResidentesSpecifications.residenteConFacturasEnMora());
            filtroIndicador.add("3");
        }

        spec = spec.and(filtrosOr);

        List<Residentes> residentesList = repository.findAll(spec, Sort.by(Sort.Direction.ASC, "nombreCompleto"));


        return residentesList.stream().map(r -> mapper.toDTO(r, filtroIndicador)).toList();
    }

}
