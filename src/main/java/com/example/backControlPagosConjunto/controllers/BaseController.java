package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.services.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class BaseController <T, ID>{

    protected final BaseService<T, ID> service;

    public BaseController(BaseService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    public List<T> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<T> getById(@PathVariable ID id) {
        return service.findById(id);
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable ID id, @RequestBody T entity) {
        return service.save(entity);  // Si existe, lo actualiza
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.deleteById(id);
    }

}
