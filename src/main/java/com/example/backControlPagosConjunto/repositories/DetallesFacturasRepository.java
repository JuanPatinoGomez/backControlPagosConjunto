package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.DetallesFacturas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetallesFacturasRepository extends JpaRepository<DetallesFacturas, String> {

    List<DetallesFacturas> findByIdFactura(String idFactura);
}
