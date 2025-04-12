package com.example.backControlPagosConjunto.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "residentes")
public class Residentes {

    @Column(name = "Id", insertable = false, nullable = false, updatable = false)
    private Integer id;

    @Id
    @UuidGenerator
    @Column(name = "id_residente")
    private String idResidente;
    @Column(name = "id_tipo_documento", nullable = false)
    private String idTipoDocumento;
    @Column(name = "numero_documento", nullable = false)
    private String numeroDocumento;
    @Column(name = "primer_nombre", nullable = false)
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Column(name = "primer_apellido", nullable = false)
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "numero_vivienda", nullable = false)
    private String numeroVivienda;
    @Column(name = "id_tipo_vivienda", nullable = false)
    private String idTipoVivienda;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdResidente() {
        return idResidente;
    }

    public void setIdResidente(String idResidente) {
        this.idResidente = idResidente;
    }

    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNumeroVivienda() {
        return numeroVivienda;
    }

    public void setNumeroVivienda(String numeroVivienda) {
        this.numeroVivienda = numeroVivienda;
    }

    public String getIdTipoVivienda() {
        return idTipoVivienda;
    }

    public void setIdTipoVivienda(String idTipoVivienda) {
        this.idTipoVivienda = idTipoVivienda;
    }
}
