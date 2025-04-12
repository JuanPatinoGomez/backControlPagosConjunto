package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.MetodosPagos;
import com.example.backControlPagosConjunto.models.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetodosPagosRepository extends JpaRepository<MetodosPagos, String> {
}
