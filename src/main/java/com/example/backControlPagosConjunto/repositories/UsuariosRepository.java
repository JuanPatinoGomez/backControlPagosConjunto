package com.example.backControlPagosConjunto.repositories;

import com.example.backControlPagosConjunto.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, String> {
    Usuarios findByUsuario(String usuario);
}
