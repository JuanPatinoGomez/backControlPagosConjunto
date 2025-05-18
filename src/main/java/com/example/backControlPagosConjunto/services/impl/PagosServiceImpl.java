package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.models.FacturasDTO;
import com.example.backControlPagosConjunto.dtos.models.MetodosPagosDTO;
import com.example.backControlPagosConjunto.dtos.models.PagosDTO;
import com.example.backControlPagosConjunto.mappers.PagosMapper;
import com.example.backControlPagosConjunto.models.Pagos;
import com.example.backControlPagosConjunto.repositories.PagosRepository;
import com.example.backControlPagosConjunto.services.MetodosPagosService;
import com.example.backControlPagosConjunto.services.PagosService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagosServiceImpl extends BaseServiceImpl<Pagos, PagosDTO, String> implements PagosService {

    private final PagosMapper mapper;
    private final PagosRepository repository;
    private final MetodosPagosService metodosPagosService;

    public PagosServiceImpl(PagosRepository repository, PagosMapper mapper, MetodosPagosService metodosPagosService) {
        super(repository, mapper);
        this.mapper = mapper;
        this.repository = repository;
        this.metodosPagosService = metodosPagosService;
    }

    @Override
    public List<PagosDTO> findByIdFactura(String idFactura) {
        return mapper.toDTOList(repository.findByIdFactura(idFactura));
    }

    @Override
    public Boolean revisarYgeneracionPagoManual(FacturasDTO factura) {
        List<PagosDTO> pagosFactura = this.findByIdFactura(factura.getIdFactura());

        Long totalFactura = factura.getTotal();

        Long totalPagado = pagosFactura.stream().filter(p -> p.getMonto() != null).mapToLong(PagosDTO::getMonto).sum();

        if(totalFactura > totalPagado) {
            MetodosPagosDTO metodoPagoManual = this.metodosPagosService.findByCodigo("MANU");
            if(metodoPagoManual == null) return false;
            PagosDTO pagosDTO = new PagosDTO();
            pagosDTO.setIdFactura(factura.getIdFactura());
            pagosDTO.setIdResidente(factura.getIdResidente());
            pagosDTO.setFechaPago(LocalDateTime.now());
            pagosDTO.setMonto(totalFactura - totalPagado);
            pagosDTO.setIdMetodoPago(metodoPagoManual.getIdMetodoPago());
            super.save(pagosDTO);
        }

        return true;
    }
}
