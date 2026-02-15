package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.Residentes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface ResidentesRepository extends JpaRepository<Residentes, UUID> , JpaSpecificationExecutor<Residentes> {

    List<Residentes> findAllByNombreCompletoContainingIgnoreCaseOrderByNombreCompletoAsc(String nombre);
    Page<Residentes> findAllByNombreCompletoContainingIgnoreCase(String nombre, Pageable pageable);
}
