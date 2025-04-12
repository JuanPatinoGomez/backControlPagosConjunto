package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.Servicios;
import com.example.backControlPagosConjunto.models.TiposViviendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiciosRepository extends JpaRepository<Servicios, String> {
}
