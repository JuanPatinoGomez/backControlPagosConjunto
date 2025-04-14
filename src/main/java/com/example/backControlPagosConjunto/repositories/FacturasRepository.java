package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.Facturas;
import com.example.backControlPagosConjunto.models.MetodosPagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FacturasRepository extends JpaRepository<Facturas, String>, JpaSpecificationExecutor<Facturas> {
}
