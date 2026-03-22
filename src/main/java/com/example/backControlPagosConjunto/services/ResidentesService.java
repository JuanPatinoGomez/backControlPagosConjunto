package com.example.backControlPagosConjunto.services;

import com.example.backControlPagosConjunto.dtos.models.ResidentesDTO;
import com.example.backControlPagosConjunto.dtos.general.GeneralSearchDTO;
import com.example.backControlPagosConjunto.dtos.operatives.ResidenteResponse;
import com.example.backControlPagosConjunto.dtos.operatives.ResidentesFilterDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ResidentesService extends BaseService<ResidentesDTO, UUID>{
    // Aquí puedes agregar métodos específicos para el modelo
    List<ResidentesDTO> findAllByNombreCompletoContainingIgnoreCaseOrderByNombreCompletoAsc(String nombre);

    Page<ResidentesDTO> findAllByNombreCompletoContainingIgnoreCase(GeneralSearchDTO search);

    List<ResidentesDTO> findAllWithFilters(ResidentesFilterDTO filterDTO);

    ResidenteResponse getAllResidentes(int pageNo, int pageSize);

    ResidentesDTO getById(UUID id);
}
