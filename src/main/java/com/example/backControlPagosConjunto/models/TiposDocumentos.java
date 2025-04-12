package com.example.backControlPagosConjunto.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "tipos_documentos")
@Data
@EqualsAndHashCode(callSuper = true)
public class TiposDocumentos extends BaseEntidad {

    @Id
    @UuidGenerator
    @Column(name = "id_tipo_documento", nullable = false)
    private String idTipoDocumento;
}
