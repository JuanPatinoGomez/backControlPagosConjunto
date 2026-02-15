package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.Usuarios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, UUID> {
    Usuarios findByUsuario(String usuario);
}
