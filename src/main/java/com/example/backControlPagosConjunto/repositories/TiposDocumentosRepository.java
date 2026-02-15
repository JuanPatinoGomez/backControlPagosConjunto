package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.TiposDocumentos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TiposDocumentosRepository extends JpaRepository<TiposDocumentos, UUID> {
}
