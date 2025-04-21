package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagosRepository extends JpaRepository<Pagos, String> {

    List<Pagos> findByIdFactura(String idFactura);
}
