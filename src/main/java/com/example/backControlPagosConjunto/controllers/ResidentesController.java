package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.dtos.models.ResidentesDTO;
import com.example.backControlPagosConjunto.dtos.general.GeneralSearchDTO;
import com.example.backControlPagosConjunto.dtos.operatives.FacturasFilterDTO;
import com.example.backControlPagosConjunto.dtos.operatives.ResidentesFilterDTO;
import com.example.backControlPagosConjunto.services.ResidentesService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/residentes")
public class ResidentesController extends BaseController<ResidentesDTO, UUID>{

    private final ResidentesService service;

    public ResidentesController(ResidentesService service) {
        super(service);
        this.service = service;
    }

    //Metodos adicionales
    @PostMapping("/nombreCompleto/orderByNameASC")
    public List<ResidentesDTO> findAllByNombreCompletoContainingIgnoreCaseOrderByNombreCompletoDesc(@RequestBody String nombre) {
        return service.findAllByNombreCompletoContainingIgnoreCaseOrderByNombreCompletoAsc(nombre);
    }

    @PostMapping("/nombreCompleto/paginated/orderByNameASC")
    public Page<ResidentesDTO> findByNombreCompletoOrderByNameASC(@RequestBody GeneralSearchDTO search) {
        return service.findAllByNombreCompletoContainingIgnoreCase(search);
    }

    @PostMapping("/search/all/filters")
    public List<ResidentesDTO> findAllWithFilters(@RequestBody ResidentesFilterDTO filterDTO){
        return service.findAllWithFilters(filterDTO);
    }

}
