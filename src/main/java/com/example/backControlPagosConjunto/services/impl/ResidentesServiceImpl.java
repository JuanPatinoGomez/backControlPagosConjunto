package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.models.ResidentesDTO;
import com.example.backControlPagosConjunto.dtos.general.GeneralSearchDTO;
import com.example.backControlPagosConjunto.mappers.ResidentesMapper;
import com.example.backControlPagosConjunto.models.Residentes;
import com.example.backControlPagosConjunto.repositories.ResidentesRepository;
import com.example.backControlPagosConjunto.services.ResidentesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
}
