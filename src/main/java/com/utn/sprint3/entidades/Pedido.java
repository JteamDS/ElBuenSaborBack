package com.utn.sprint3.entidades;

import com.utn.sprint3.enumeraciones.EstadoPedido;
import com.utn.sprint3.enumeraciones.FormaPago;
import com.utn.sprint3.enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Pedido extends BaseEntidad {

    @NotNull
    @Column(name = "fecha_pedido")
    private String fechaPedido;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    @NotNull
    private float total;

    @NotNull
    private float totalCosto;

    @ManyToOne()
    @JoinColumn(name = "id_domicilio_entrega")
    private Domicilio domicilioEntrega;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pedido")
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;


}
