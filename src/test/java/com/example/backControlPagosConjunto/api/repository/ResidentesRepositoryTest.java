package com.example.backControlPagosConjunto.api.repository;

import java.util.List;
import java.util.UUID;

import com.example.backControlPagosConjunto.models.TiposDocumentos;
import com.example.backControlPagosConjunto.models.TiposViviendas;
import com.example.backControlPagosConjunto.repositories.TiposDocumentosRepository;
import com.example.backControlPagosConjunto.repositories.TiposViviendasRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;

import com.example.backControlPagosConjunto.models.Residentes;
import com.example.backControlPagosConjunto.repositories.ResidentesRepository;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //Esto se pone pq DataJpaTest asigna una base h2 directamente
public class ResidentesRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:16.0"));

    @Autowired
    private ResidentesRepository residentesRepository;

    @Autowired
    private TiposDocumentosRepository tiposDocumentosRepository;

    @Autowired
    private TiposViviendasRepository tiposViviendasRepository;

    @Autowired
    private EntityManager entityManager;



//    @DynamicPropertySource
//    static void configureProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgres::getJdbcUrl);
//        registry.add("spring.datasource.username", postgres::getUsername);
//        registry.add("spring.datasource.password", postgres::getPassword);
//    }


    @Test
    public void connectionEstablished() {
        Assertions.assertThat(postgres.isCreated()).isTrue();
        Assertions.assertThat(postgres.isRunning()).isTrue();
    }

    @Test
    public void ResidentesRepository_saveAll_ReturnSavedResident(){

        System.out.println(postgres.getJdbcUrl());
        //Arrange
        Residentes residente = Residentes.builder()
        .idTipoDocumento(UUID.fromString("11111111-aaaa-bbbb-cccc-111111111111"))
        .idTipoVivienda(UUID.fromString("33333333-aaaa-bbbb-cccc-333333333333"))
        .numeroDocumento("123456789")
        .nombreCompleto("Mario Bros")
        .numeroVivienda("A500").build();

        //Act

        Residentes residenteGuardado = residentesRepository.save(residente);
        entityManager.flush(); //Ejecuta los insert de una vez en la base de datos
        entityManager.clear();


        //Assert

        Assertions.assertThat(residenteGuardado).isNotNull().extracting(Residentes::getIdResidente).isNotNull();
    }

    @Test
    public void ResidentesRepository_GetAll_ReturnMoreThanOneResidente(){

        //Arrange
        UUID idTipoDocumento = crearTipoDocumento();
        UUID idTIpoVivienda = crearTipoVivienda();

        Residentes residente1 = Residentes.builder()
        .idTipoDocumento(idTipoDocumento)
        .idTipoVivienda(idTIpoVivienda)
        .numeroDocumento("123456789")
        .nombreCompleto("Mario Bros")
        .numeroVivienda("A500").build();

        Residentes residente2 = Residentes.builder()
        .idTipoDocumento(idTipoDocumento)
        .idTipoVivienda(idTIpoVivienda)
        .numeroDocumento("98765432")
        .nombreCompleto("Ivanna")
        .numeroVivienda("A600").build();

        residentesRepository.save(residente1);

        residentesRepository.save(residente2);

        List<Residentes> residentesList = residentesRepository.findAll();

        residentesList.forEach(s -> System.out.println(s.toString()));

        Assertions.assertThat(residentesList).isNotNull();
        Assertions.assertThat(residentesList.size()).isEqualTo(2);


    }


    private UUID crearTipoDocumento(){
        TiposDocumentos tipoDocumento = new TiposDocumentos();
        tipoDocumento.setNombre("cedula ciudadania");
        tipoDocumento.setCodigo("CC");
        tipoDocumento = tiposDocumentosRepository.save(tipoDocumento);
        return tipoDocumento.getIdTipoDocumento();
    }

    private UUID crearTipoVivienda(){
        TiposViviendas obj = new TiposViviendas();
        obj.setNombre("apartamento");
        obj.setCodigo("APART");
        obj = tiposViviendasRepository.save(obj);
        return obj.getIdTipoVivienda();
    }


    @Test
    public void ResidentesRepository_findById_ReturnResident(){

        System.out.println(postgres.getJdbcUrl());
        //Arrange

        UUID idTipoDocumento = crearTipoDocumento();
        UUID idTIpoVivienda = crearTipoVivienda();


        Residentes residente = Residentes.builder()
                .idTipoDocumento(idTipoDocumento)
                .idTipoVivienda(idTIpoVivienda)
                .numeroDocumento("123456789")
                .nombreCompleto("Mario Bros")
                .numeroVivienda("A500").build();

        //Act

        residentesRepository.save(residente);

        Residentes residenteBuscado = residentesRepository.findById(residente.getIdResidente()).orElse(null);

        //Assert

        Assertions.assertThat(residenteBuscado).isNotNull().extracting(Residentes::getIdResidente).isNotNull();
    }


}
