package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.DetallesFacturas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DetallesFacturasRepository extends JpaRepository<DetallesFacturas, UUID> {

    List<DetallesFacturas> findByIdFactura(UUID idFactura);
}
