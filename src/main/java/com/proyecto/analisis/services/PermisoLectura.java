package com.proyecto.analisis.services;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
public class PermisoLectura extends Permiso {

    public PermisoLectura(){
        nombrePermiso = "Permiso Lectura";
        estadoPermiso = false;
    }

    @Override
    public void aplicarPermiso() {
        estadoPermiso = true;
    }
}
