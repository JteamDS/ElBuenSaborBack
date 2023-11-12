package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Producto extends BaseEntidad {

    @NotNull
    private String nombre;
    @Column(length = 1000)
    private String descripcion;
    @NotNull
    private float precioVenta;
    @NotNull
    private float costo;
    @NotNull
    private float stockActual;
    @NotNull
    private float stockMinimo;
    @ManyToOne()
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;
}
