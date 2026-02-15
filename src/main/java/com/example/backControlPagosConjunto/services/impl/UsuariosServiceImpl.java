package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.models.UsuariosDTO;
import com.example.backControlPagosConjunto.mappers.UsuariosMapper;
import com.example.backControlPagosConjunto.models.Usuarios;
import com.example.backControlPagosConjunto.repositories.UsuariosRepository;
import com.example.backControlPagosConjunto.services.UsuariosService;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl extends BaseServiceImpl<Usuarios, UsuariosDTO, UUID> implements UsuariosService {

    private final UsuariosRepository repository;
    private final UsuariosMapper mapper;

    public UsuariosServiceImpl(UsuariosRepository repository, UsuariosRepository repository1, UsuariosMapper mapper) {
        super(repository, mapper);
        this.repository = repository1;
        this.mapper = mapper;
    }

    @Override
    public UsuariosDTO save(UsuariosDTO dto){
        Usuarios user = mapper.toEntity(dto);
        if(user.getId() == null && user.getContrasena() != null) { // Cuando el usuario es nuevo
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setContrasena(encoder.encode(user.getContrasena()));
        }
        Usuarios saved = repository.save(user);
        return mapper.toDTO(saved);
    }

    @Override
    public Boolean validarLogin(String usuario, String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        UsuariosDTO user = findByUsuario(usuario);
        if(user == null) return false;
        return encoder.matches(password, user.getContrasena());
    }

    @Override
    public UsuariosDTO findByUsuario(String usuario) {
        return this.mapper.toDTO(repository.findByUsuario(usuario));
    }
}
