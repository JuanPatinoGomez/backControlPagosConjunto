package com.example.backControlPagosConjunto.services;

import java.util.List;

public interface BaseService<DTO, ID> {

    DTO save(DTO entity);
    DTO findById(ID id);
    List<DTO> findAll();
    DTO update(ID id, DTO entity);
    void deleteById(ID id);
}
