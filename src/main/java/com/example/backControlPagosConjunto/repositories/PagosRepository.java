package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PagosRepository extends JpaRepository<Pagos, UUID> {

    List<Pagos> findByIdFactura(UUID idFactura);
}
