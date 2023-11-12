package com.utn.sprint3.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado extends BaseEntidad{
    @NotNull
    String nombre;
    @NotNull
    String apellido;
    @NotNull
    String email;
    @NotNull
    String telefono;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
