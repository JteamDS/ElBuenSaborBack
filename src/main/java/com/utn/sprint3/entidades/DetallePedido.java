package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DetallePedido extends BaseEntidad{

    @NotNull
    private Integer cantidad;

    @NotNull
    private float subtotal;

    @ManyToOne()
    @JoinColumn(name = "id-producto")
    private Producto producto;

}