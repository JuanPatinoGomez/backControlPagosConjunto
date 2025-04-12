package com.example.backControlPagosConjunto.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
public class Facturas {

    @Column(name = "id", insertable = false, nullable = false, updatable = false)
    private Integer id;

    @Id
    @UuidGenerator
    @Column(name = "id_factura", nullable = false)
    private String idFactura;

    @Column(name = "id_residente" , nullable = false)
    private String idResidente;

    @Column(name = "fecha_emision" , nullable = false)
    private LocalDateTime fechaEmision;
    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDateTime fechaVencimiento;
    @Column(name = "total", nullable = false)
    private Long total;
    @Column(name = "estado", nullable = false)
    private Boolean estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getIdResidente() {
        return idResidente;
    }

    public void setIdResidente(String idResidente) {
        this.idResidente = idResidente;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
