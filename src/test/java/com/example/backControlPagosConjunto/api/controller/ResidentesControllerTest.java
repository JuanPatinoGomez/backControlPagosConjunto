package com.example.backControlPagosConjunto.api.controller;

import com.example.backControlPagosConjunto.controllers.ResidentesController;
import com.example.backControlPagosConjunto.dtos.models.ResidentesDTO;
import com.example.backControlPagosConjunto.dtos.operatives.ResidenteResponse;
import com.example.backControlPagosConjunto.models.Residentes;
import com.example.backControlPagosConjunto.services.ResidentesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(ResidentesController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ResidentesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ResidentesService residentesService;

    @Autowired
    private ObjectMapper objectMapper;

    private Residentes residentes;
    private ResidentesDTO residentesDTO;


    @BeforeEach
    public void init(){
        residentes = Residentes.builder()
                .idTipoDocumento(UUID.randomUUID())
                .idTipoVivienda(UUID.randomUUID())
                .numeroDocumento("123456789")
                .nombreCompleto("Mario Bros")
                .numeroVivienda("A500").build();

        residentesDTO = ResidentesDTO.builder()
                .idTipoDocumento(UUID.randomUUID())
                .idTipoVivienda(UUID.randomUUID())
                .numeroDocumento("123456789")
                .nombreCompleto("Mario Bros")
                .numeroVivienda("A500").build();
    }

    @Test
    public void ResidentesController_create_returnResidente() throws Exception {

        //Cuando se hace el save, devuelve el mismo argumento que recibio
        given(residentesService.save(ArgumentMatchers.any())).willAnswer(invocation -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/api/residentes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(residentesDTO)));

        response.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.numeroDocumento").value(residentesDTO.getNumeroDocumento()))
                .andDo(MockMvcResultHandlers.print()//Impresion en consola
                );

    }


    @Test
    public void ResidentesController_GetAll_returnResidenteDTO() throws Exception {
        ResidenteResponse responseDto = ResidenteResponse.builder().pageSize(10).pageNo(1).totalPages(1).totalElements(1L).content(Arrays.asList(residentesDTO)).build();


        when(residentesService.getAllResidentes(1,10)).thenReturn(responseDto);

        ResultActions response = mockMvc.perform(get("/api/residentes/allResidentes/pageNo/1/pageSize/10")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content.size()").value(responseDto.getContent().size()))
                .andDo(MockMvcResultHandlers.print())
        ;
    }


}
