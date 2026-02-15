package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.Facturas;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FacturasRepository extends JpaRepository<Facturas, UUID>, JpaSpecificationExecutor<Facturas> {
}
