package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.services.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController <DTO,ID>{

    protected final BaseService<DTO,ID> service;

    public BaseController(BaseService<DTO, ID> service) {
        this.service = service;
    }

    @GetMapping
    public List<DTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DTO getById(@PathVariable ID id) {
        return service.findById(id);
    }

    @PostMapping
    public DTO create(@RequestBody DTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public DTO update(@PathVariable ID id, @RequestBody DTO dto) {
        return service.save(dto);  // Si existe, lo actualiza
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.deleteById(id);
    }

}
