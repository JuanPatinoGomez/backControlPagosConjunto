package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.MetodosPagos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MetodosPagosRepository extends JpaRepository<MetodosPagos, UUID> {

    MetodosPagos findByCodigo(String codigo);
}
