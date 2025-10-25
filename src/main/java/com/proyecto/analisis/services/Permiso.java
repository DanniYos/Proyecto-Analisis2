package com.proyecto.analisis.services;

import lombok.Data;

@Data
public abstract class Permiso {

    protected String nombrePermiso;
    protected boolean estadoPermiso;

    public abstract void aplicarPermiso();
}
