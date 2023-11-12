package com.utn.sprint3.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleNota extends BaseEntidad{

    @NotNull
    private Integer cantidad;
    @NotNull
    private float subtotal;
    @ManyToOne()
    @JoinColumn(name = "id-producto")
    private Producto producto;

}
