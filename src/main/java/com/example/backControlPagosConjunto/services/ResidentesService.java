package com.example.backControlPagosConjunto.services;

import com.example.backControlPagosConjunto.dtos.models.ResidentesDTO;
import com.example.backControlPagosConjunto.dtos.general.GeneralSearchDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ResidentesService extends BaseService<ResidentesDTO, String>{
    // Aquí puedes agregar métodos específicos para el modelo
    List<ResidentesDTO> findAllByNombreCompletoContainingIgnoreCaseOrderByNombreCompletoAsc(String nombre);

    Page<ResidentesDTO> findAllByNombreCompletoContainingIgnoreCase(GeneralSearchDTO search);
}
