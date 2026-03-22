package com.example.backControlPagosConjunto.controllers;

import com.example.backControlPagosConjunto.dtos.models.ResidentesDTO;
import com.example.backControlPagosConjunto.dtos.general.GeneralSearchDTO;
import com.example.backControlPagosConjunto.dtos.operatives.ResidenteResponse;
import com.example.backControlPagosConjunto.dtos.operatives.ResidentesFilterDTO;
import com.example.backControlPagosConjunto.exceptions.ResourceNotFoundException;
import com.example.backControlPagosConjunto.services.ResidentesService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/allResidentes/pageNo/{pageNo}/pageSize/{pageSize}")
    public ResponseEntity<ResidenteResponse> getAllResidentes(@PathVariable int pageNo, @PathVariable int pageSize){
        return ResponseEntity.ok(service.getAllResidentes(pageNo, pageSize));
    }


    // Mamipulación de las excepciones
    @GetMapping("/ex/buscar/{id}")
    public ResponseEntity<?> pruebaExcepciones(@PathVariable UUID id){
        ResidentesDTO residenteDTO = service.findById(id);

        if(residenteDTO == null){
            throw new ResourceNotFoundException("residente", "id", id.toString());
        }

        return ResponseEntity.ok(residenteDTO);
    }

    @GetMapping("/ex/buscarAll")
    public ResponseEntity<?> pruebaExcepcionesLista(){
        List<ResidentesDTO> residentesDTOList = service.findAll();
        residentesDTOList.clear();
        if(residentesDTOList.isEmpty()){
            throw new ResourceNotFoundException("residente");
        }

        return ResponseEntity.ok(residentesDTOList);
    }

    @PostMapping("/ex/crear")
    public ResponseEntity<?> pruebaExcepciones(@Valid @RequestBody ResidentesDTO residentesDTO){
        ResidentesDTO residenteDTO = service.save(residentesDTO);



        return ResponseEntity.ok(residenteDTO);
    }

}
