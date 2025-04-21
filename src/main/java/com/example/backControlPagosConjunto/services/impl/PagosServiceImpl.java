package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.models.PagosDTO;
import com.example.backControlPagosConjunto.mappers.PagosMapper;
import com.example.backControlPagosConjunto.models.Pagos;
import com.example.backControlPagosConjunto.repositories.PagosRepository;
import com.example.backControlPagosConjunto.services.PagosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagosServiceImpl extends BaseServiceImpl<Pagos, PagosDTO, String> implements PagosService {

    private final PagosMapper mapper;
    private final PagosRepository repository;

    public PagosServiceImpl(PagosRepository repository, PagosMapper mapper) {
        super(repository, mapper);
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<PagosDTO> findByIdFactura(String idFactura) {
        return mapper.toDTOList(repository.findByIdFactura(idFactura));
    }
}
