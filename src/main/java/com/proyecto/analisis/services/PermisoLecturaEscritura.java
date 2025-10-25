package com.proyecto.analisis.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
public class PermisoLecturaEscritura extends Permiso{

    public PermisoLecturaEscritura() {
        nombrePermiso = "Permiso lectura escritura";
        estadoPermiso = false;
    }

    @Override
    public void aplicarPermiso() {
        estadoPermiso = true;
    }
}
