package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.Residentes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResidentesRepository extends JpaRepository<Residentes, String> {

    List<Residentes> findAllByNombreCompletoContainingIgnoreCaseOrderByNombreCompletoAsc(String nombre);
    Page<Residentes> findAllByNombreCompletoContainingIgnoreCase(String nombre, Pageable pageable);
}
