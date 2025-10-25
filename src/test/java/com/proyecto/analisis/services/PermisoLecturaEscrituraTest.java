package com.proyecto.analisis.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PermisoLecturaEscrituraTest {

    private PermisoFactory permisoFactory;
    private Permiso permisoLecturaEscritura;

    @Before
    public void onInit(){
        permisoFactory = new PermisoFactoryMethod();
        permisoLecturaEscritura = permisoFactory.createPermiso("lectura_escritura");
    }

    @Test
    public void testAplicarPermiso() {
        permisoLecturaEscritura.aplicarPermiso();
        Assert.assertEquals("Permiso lectura escritura", permisoLecturaEscritura.nombrePermiso);
        Assert.assertTrue(permisoLecturaEscritura.estadoPermiso);
    }
}