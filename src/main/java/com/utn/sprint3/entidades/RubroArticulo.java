package com.utn.sprint3.entidades;

import com.utn.sprint3.enumeraciones.EstadoRubro;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rubro_articulo")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RubroArticulo extends BaseEntidad {

    @NotNull
    private String nombre;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoRubro estadoRubro;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id-rubro")
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

}
