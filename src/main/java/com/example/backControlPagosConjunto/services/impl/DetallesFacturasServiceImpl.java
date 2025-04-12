package com.example.backControlPagosConjunto.services.impl;

import com.example.backControlPagosConjunto.dtos.DetallesFacturasDTO;
import com.example.backControlPagosConjunto.mappers.DetallesFacturasMapper;
import com.example.backControlPagosConjunto.models.DetallesFacturas;
import com.example.backControlPagosConjunto.repositories.DetallesFacturasRepository;
import com.example.backControlPagosConjunto.services.DetallesFacturasService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetallesFacturasServiceImpl extends BaseServiceImpl<DetallesFacturas, String> implements DetallesFacturasService {

    private final DetallesFacturasRepository repository;
    private final DetallesFacturasMapper mapper;

    public DetallesFacturasServiceImpl(DetallesFacturasRepository repository, DetallesFacturasMapper mapper) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DetallesFacturasDTO> findByIdFactura(String idFactura) {
        List<DetallesFacturas> detallesFacturas = repository.findByIdFactura(idFactura);
        System.out.println(this.mapper.toDTO(detallesFacturas.stream().findFirst().get()));

        DetallesFacturas factura = new DetallesFacturas();
        factura.setIdDetalleFactura("abc123");
        factura.setIdFactura("fac001");
        factura.setIdServicio("srv123");
        factura.setMonto(50000L);

        // Usa MapStruct sin Spring para test
        DetallesFacturasMapper mapper = Mappers.getMapper(DetallesFacturasMapper.class);
        DetallesFacturasDTO dto = mapper.toDTO(factura);

        System.out.println(dto); // ¿sigue saliendo todo null?

        return this.mapper.toDTOList(detallesFacturas);
    }
}
