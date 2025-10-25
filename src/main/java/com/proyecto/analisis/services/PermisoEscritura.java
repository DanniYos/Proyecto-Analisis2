package com.proyecto.analisis.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
public class PermisoEscritura extends Permiso {

    public PermisoEscritura(){
        nombrePermiso = "Permiso Escritura";
        estadoPermiso = false;
    }


    @Override
    public void aplicarPermiso() {
        estadoPermiso = true;
    }
}
