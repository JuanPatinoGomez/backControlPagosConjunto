package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.Residentes;
import com.example.backControlPagosConjunto.models.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentesRepository extends JpaRepository<Residentes, String> {
}
