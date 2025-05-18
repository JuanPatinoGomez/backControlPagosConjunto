package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.MetodosPagos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetodosPagosRepository extends JpaRepository<MetodosPagos, String> {

    MetodosPagos findByCodigo(String codigo);
}
