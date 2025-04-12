package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.Pagos;
import com.example.backControlPagosConjunto.models.Residentes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagosRepository extends JpaRepository<Pagos, String> {
}
