package com.proyecto.analisis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermisoService {

    @Autowired
    private PermisoFactory permisoFactory;


    public Permiso permiso(String tipoPermiso){
        return permisoFactory.createPermiso(tipoPermiso);
    }

}
