package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotaCredito extends BaseEntidad{

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;
    @NotNull
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id-nota-credito")
    private List<DetalleNota> detalleNotas = new ArrayList<>();
    @NotNull
    private float totalDevolucion;

}
