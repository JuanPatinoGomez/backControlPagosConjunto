package com.example.backControlPagosConjunto.specifications;

import com.example.backControlPagosConjunto.models.Facturas;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class FacturasSpecifications {


    // -> root: representa la entidad que estás consultando (por ejemplo, Factura).
    // -> query: representa la consulta que se está construyendo.
    // -> cb (CriteriaBuilder): es un ayudante para construir condiciones (where, like, between, etc.).

    public static Specification<Facturas> facturasPorNombreResidente(String nombre) {
        return (root, query, cb) -> {
            if(nombre == null || nombre.isBlank()) return null;
            return cb.like(cb.lower(root.get("residente").get("nombreCompleto")),"%" + nombre.toLowerCase() + "%");
        };
    }

    public static Specification<Facturas> facturasPorCodigoFactura(String codigoFactura) {
        return (root, query, cb) -> {
            if(codigoFactura == null || codigoFactura.isBlank()) return null;
            return cb.like(cb.lower(root.get("residente").get("nombreCompleto")),"%" + codigoFactura.toLowerCase() + "%");
        };
    }

    public static Specification<Facturas> facturasPorIdResidente(String idResidente) {
        return (root, query, cb) -> {
            if(idResidente == null || idResidente.isBlank()) return null;
            return cb.equal(root.get("idResidente"), idResidente.toLowerCase());
        };
    }

    public static Specification<Facturas> facturasAlDia(){
        return (root, query, cb) -> cb.isTrue(root.get("estado"));
    }
    public static Specification<Facturas> facturasPendientes(){
        LocalDateTime fechaActual = LocalDateTime.now();
        return (root, query, cb) -> cb.and(cb.greaterThan(root.get("fechaVencimiento"), fechaActual),
                cb.equal(root.get("estado"), false));
    }

    public static Specification<Facturas> facturasEnMora(){
        LocalDateTime fechaActual = LocalDateTime.now();
        return (root, query, cb) -> cb.and(cb.lessThanOrEqualTo(root.get("fechaVencimiento"), fechaActual),
                cb.equal(root.get("estado"), false));
    }
}
