package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.TiposDocumentos;
import com.example.backControlPagosConjunto.models.TiposViviendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiposViviendasRepository extends JpaRepository<TiposViviendas, String> {
}
