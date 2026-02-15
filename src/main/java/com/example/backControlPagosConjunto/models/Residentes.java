package com.example.backControlPagosConjunto.models;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "residentes")
@Data
public class Residentes {

    @Column(name = "Id", insertable = false, nullable = false, updatable = false)
    private Integer id;

    @Id
    @UuidGenerator
    @Column(name = "id_residente")
    private UUID idResidente;
    @Column(name = "id_tipo_documento", nullable = false)
    private UUID idTipoDocumento;
    @Column(name = "numero_documento", nullable = false)
    private String numeroDocumento;
    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;
    @Column(name = "numero_vivienda", nullable = false)
    private String numeroVivienda;
    @Column(name = "id_tipo_vivienda", nullable = false)
    private UUID idTipoVivienda;

    @OneToMany(mappedBy = "residente")
    private List<Facturas> facturasList;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento", insertable = false, updatable = false)
    private TiposDocumentos tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_vivienda", referencedColumnName = "id_tipo_vivienda", insertable = false, updatable = false)
    private TiposViviendas tipoVivienda;
}
