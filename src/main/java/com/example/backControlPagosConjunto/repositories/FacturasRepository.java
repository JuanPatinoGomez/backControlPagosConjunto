package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.Facturas;
import com.example.backControlPagosConjunto.models.MetodosPagos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturasRepository extends JpaRepository<Facturas, String> {
}
