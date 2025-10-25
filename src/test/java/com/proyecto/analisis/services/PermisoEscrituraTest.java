package com.proyecto.analisis.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PermisoEscrituraTest {

    private PermisoFactory permisoFactory;
    private Permiso permisEscritura;

    @Before
    public void onInit(){
        permisoFactory = new PermisoFactoryMethod();
        permisEscritura = permisoFactory.createPermiso("escritura");
    }

    @Test
    public void testAplicarPermiso() {
        permisEscritura.aplicarPermiso();
        Assert.assertEquals("Permiso Escritura", permisEscritura.nombrePermiso);
        Assert.assertTrue(permisEscritura.estadoPermiso);
    }
}