package com.utn.sprint3.entidades;

import com.utn.sprint3.enumeraciones.EstadoFactura;
import com.utn.sprint3.enumeraciones.FormaPago;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Factura extends BaseEntidad {

    @NotNull
    @Column(name = "fecha_facturacion")
    private String fechaFacturacion;

    @NotNull
    private FormaPago formaPago;

    @NotNull
    private float totalVenta;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id-factura")
    private List<DetalleFactura> detalleFacturas = new ArrayList<>();

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoFactura estadoFactura;
}
