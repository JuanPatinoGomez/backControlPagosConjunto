package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.mappers.GenericMapper;
import com.example.backControlPagosConjunto.services.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public class BaseServiceImpl<ENTITY, DTO, ID> implements BaseService<DTO, ID> {


    protected final JpaRepository<ENTITY, ID> repository;
    protected final GenericMapper<ENTITY, DTO> mapper;

    public BaseServiceImpl(JpaRepository<ENTITY, ID> repository,  GenericMapper<ENTITY, DTO> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DTO save(DTO dto) {
        ENTITY entity = this.mapper.toEntity(dto);
        return this.mapper.toDTO(repository.save(entity));
    }

    @Override
    public DTO findById(ID id) {
        return this.mapper.toDTO(repository.findById(id).orElse(null));
    }

    @Override
    public List<DTO> findAll() {
        return this.mapper.toDTOList(repository.findAll());
    }

    @Override
    public DTO update(ID id, DTO dto) {
        ENTITY entity = this.mapper.toEntity(dto);
        return this.mapper.toDTO(repository.save(entity));
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
