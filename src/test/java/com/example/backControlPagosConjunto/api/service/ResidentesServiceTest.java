package com.example.backControlPagosConjunto.api.service;

import com.example.backControlPagosConjunto.dtos.models.ResidentesDTO;
import com.example.backControlPagosConjunto.dtos.operatives.ResidenteResponse;
import com.example.backControlPagosConjunto.mappers.ResidentesMapper;
import com.example.backControlPagosConjunto.models.Residentes;
import com.example.backControlPagosConjunto.repositories.ResidentesRepository;
import com.example.backControlPagosConjunto.services.impl.ResidentesServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ResidentesServiceTest {

    @Mock
    private ResidentesRepository residentesRepository;

    private ResidentesServiceImpl residentesServiceImpl;

    private final ResidentesMapper residentesMapper =
            Mappers.getMapper(ResidentesMapper.class);

    @BeforeEach
    void setUp() {
        residentesServiceImpl = new ResidentesServiceImpl(
                residentesRepository,
                residentesMapper
        );
    }

    @Test
    void residentesService_create(){
        Residentes residente = Residentes.builder()
                .idTipoDocumento(UUID.randomUUID())
                .idTipoVivienda(UUID.randomUUID())
                .numeroDocumento("123456789")
                .nombreCompleto("Mario Bros")
                .numeroVivienda("A500").build();

        when(residentesRepository.save(any(Residentes.class))).thenReturn(residente); // Se intercepta el save, para que cuando se ejecute devuelva el residente que definimos


        ResidentesDTO residenteGuardado =  residentesServiceImpl.save(residentesMapper.toDTO(residente));

        Assertions.assertNotNull(residenteGuardado);

    }

    @Test
    void residentesService_getAllResidentes(){
        Page<Residentes> residentesPage = Mockito.mock(Page.class);

        when(residentesRepository.findAll(any(Pageable.class))).thenReturn(residentesPage);

        ResidenteResponse responseResidentes = residentesServiceImpl.getAllResidentes(1,10);

        Assertions.assertNotNull(responseResidentes);

    }


    @Test
    void residentesService_getById(){
//        Residentes residente = Residentes.builder()
//                .idTipoDocumento(UUID.randomUUID())
//                .idTipoVivienda(UUID.randomUUID())
//                .numeroDocumento("123456789")
//                .nombreCompleto("Mario Bros")
//                .numeroVivienda("A500").build();

        Residentes residente = Mockito.mock(Residentes.class);

        UUID idResidente = UUID.randomUUID();

        when(residentesRepository.findById(idResidente)).thenReturn(Optional.ofNullable(residente)); // Se intercepta el save, para que cuando se ejecute devuelva el residente que definimos


        ResidentesDTO residenteConsultado =  residentesServiceImpl.getById(idResidente);

        Assertions.assertNotNull(residenteConsultado);

    }

}
