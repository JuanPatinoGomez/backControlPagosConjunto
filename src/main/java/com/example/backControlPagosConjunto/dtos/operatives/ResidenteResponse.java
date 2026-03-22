package com.example.backControlPagosConjunto.dtos.operatives;

import com.example.backControlPagosConjunto.dtos.models.ResidentesDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidenteResponse {

    private List<ResidentesDTO> content;
    private Integer pageNo;
    private Integer pageSize;
    private Integer totalPages;
    private Long totalElements;

}
