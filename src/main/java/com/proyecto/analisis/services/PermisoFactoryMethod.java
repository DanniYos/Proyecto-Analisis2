package com.proyecto.analisis.services;

import org.springframework.stereotype.Component;

@Component
public class PermisoFactoryMethod implements PermisoFactory {
    @Override
    public Permiso createPermiso(String tipoPermiso) {
        return switch (tipoPermiso.toLowerCase()) {
            case "lectura" -> new PermisoLectura();
            case "escritura" -> new PermisoEscritura();
            case "lectura_escritura" -> new PermisoLecturaEscritura();
            default -> throw new IllegalArgumentException("Tipo de permiso no válido: " + tipoPermiso);
        };
    }
}
