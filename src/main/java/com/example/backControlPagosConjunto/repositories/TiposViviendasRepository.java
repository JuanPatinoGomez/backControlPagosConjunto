package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.TiposViviendas;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TiposViviendasRepository extends JpaRepository<TiposViviendas, UUID> {
}
