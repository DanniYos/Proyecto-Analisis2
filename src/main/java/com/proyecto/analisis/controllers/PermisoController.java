package com.proyecto.analisis.controllers;

import com.proyecto.analisis.services.Permiso;
import com.proyecto.analisis.services.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crear-permiso")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;


    @GetMapping("{tipoPermiso}")
    public ResponseEntity<Permiso> crearPermiso(@PathVariable String tipoPermiso){
        Permiso permiso = permisoService.permiso(tipoPermiso);
        permiso.aplicarPermiso();
        return ResponseEntity.ok(permiso);
    }

}
