package com.example.backControlPagosConjunto.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
public class Pagos {

    @Column(name = "id", insertable = false, nullable = false, updatable = false)
    private Integer id;

    @Id
    @UuidGenerator
    @Column(name = "id_pago", nullable = false)
    private String idPago;

    @Column(name = "id_factura", nullable = false)
    private String idFactura;

    @Column(name = "id_residente", nullable = false)
    private String idResidente;

    @Column(name = "fecha_pago" , nullable = false)
    private LocalDateTime fechaPago;

    @Column(name = "monto", nullable = false)
    private Long monto;

    @Column(name = "id_metodo_pago", nullable = false)
    private String idMetodoPago;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
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

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public String getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(String idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }
}
