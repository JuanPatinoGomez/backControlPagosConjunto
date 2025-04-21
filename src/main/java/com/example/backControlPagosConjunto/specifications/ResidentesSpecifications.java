package com.example.backControlPagosConjunto.specifications;

import com.example.backControlPagosConjunto.models.Facturas;
import com.example.backControlPagosConjunto.models.Residentes;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class ResidentesSpecifications {

    // Filtrar por nombre de residente
    public static Specification<Residentes> residentePorNombre(String nombre) {
        return (root, query, cb) -> {
            if (nombre == null || nombre.isBlank()) return null;
            return cb.like(cb.lower(root.get("nombreCompleto")), "%" + nombre.toLowerCase() + "%");
        };
    }

    // Filtrar por id de residente
    public static Specification<Residentes> residentePorIdResidente(String idResidente) {
        return (root, query, cb) -> {
            if (idResidente == null || idResidente.isBlank()) return null;
            return cb.equal(root.get("idResidente"), idResidente);
        };
    }

//    // Filtrar por estado de factura: al día
//    public static Specification<Residentes> residenteConFacturasAlDia() {
//        return (root, query, cb) -> {
//            // JOIN entre Residentes y Facturas, basado en la columna id_residente
//            Join<Residentes, Facturas> facturasJoin = root.join("facturasList", JoinType.INNER); // Asegúrate que el nombre del campo de la relación sea correcto
//
//            // Filtra las facturas al día
//            return cb.isTrue(facturasJoin.get("estado"));
//        };
//    }

    public static Specification<Residentes> residenteConFacturasAlDia() {
        return (root, query, cb) -> {
            // JOIN entre Residentes y Facturas, basado en la columna id_residente
            Join<Residentes, Facturas> facturasJoin = root.join("facturasList", JoinType.INNER);

            // Filtra los residentes cuyo estado de todas sus facturas es true
            // Se usa un subquery para verificar que no existen facturas con estado = false
            query.distinct(true); // Asegura que no se repitan los residentes

            // Subquery que busca facturas con estado false
            Subquery<Long> subquery = query.subquery(Long.class);
            Root<Facturas> subqueryRoot = subquery.from(Facturas.class);
            subquery.select(subqueryRoot.get("id"))
                    .where(cb.equal(subqueryRoot.get("residente"), root), // Relacionamos la factura con el residente
                            cb.equal(subqueryRoot.get("estado"), false)); // Factura con estado false

            // Asegura que el residente no tiene ninguna factura con estado false
            return cb.not(cb.exists(subquery));
        };
    }

//    // Filtrar por estado de factura: pendientes
//    public static Specification<Residentes> residenteConFacturasPendientes() {
//        return (root, query, cb) -> {
//            // JOIN entre Residentes y Facturas
//            Join<Residentes, Facturas> facturasJoin = root.join("facturasList", JoinType.INNER);
//            LocalDateTime fechaActual = LocalDateTime.now();
//            return cb.and(
//                    cb.greaterThan(facturasJoin.get("fechaVencimiento"), fechaActual),
//                    cb.equal(facturasJoin.get("estado"), false) // Factura pendiente
//            );
//        };
//    }


    public static Specification<Residentes> residenteConFacturasPendientes() {
        return (root, query, cb) -> {
            LocalDateTime fechaActual = LocalDateTime.now();

            // Subconsulta: al menos una factura pendiente
            Subquery<Long> subqueryPendiente = query.subquery(Long.class);
            Root<Facturas> subRootPendiente = subqueryPendiente.from(Facturas.class);
            subqueryPendiente.select(subRootPendiente.get("id"))
                    .where(
                            cb.and(
                                    cb.equal(subRootPendiente.get("residente"), root),
                                    cb.equal(subRootPendiente.get("estado"), false),
                                    cb.greaterThan(subRootPendiente.get("fechaVencimiento"), fechaActual)
                            )
                    );

            // Subconsulta: ninguna factura en mora
            Subquery<Long> subqueryMora = query.subquery(Long.class);
            Root<Facturas> subRootMora = subqueryMora.from(Facturas.class);
            subqueryMora.select(subRootMora.get("id"))
                    .where(
                            cb.and(
                                    cb.equal(subRootMora.get("residente"), root),
                                    cb.equal(subRootMora.get("estado"), false),
                                    cb.lessThanOrEqualTo(subRootMora.get("fechaVencimiento"), fechaActual)
                            )
                    );

            // Debe existir al menos una pendiente Y no debe existir ninguna en mora
            return cb.and(
                    cb.exists(subqueryPendiente),
                    cb.not(cb.exists(subqueryMora))
            );
        };
    }

    // Filtrar por estado de factura: en mora
    public static Specification<Residentes> residenteConFacturasEnMora() {
        return (root, query, cb) -> {
            // JOIN entre Residentes y Facturas
            Join<Residentes, Facturas> facturasJoin = root.join("facturasList", JoinType.INNER);
            LocalDateTime fechaActual = LocalDateTime.now();
            return cb.and(
                    cb.lessThanOrEqualTo(facturasJoin.get("fechaVencimiento"), fechaActual),
                    cb.equal(facturasJoin.get("estado"), false) // Factura en mora
            );
        };
    }
}
