package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.Servicios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiciosRepository extends JpaRepository<Servicios, UUID> {
}
