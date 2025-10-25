package com.proyecto.analisis.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PermisoLecturaTest {

    private PermisoFactory permisoFactory;
    private Permiso permisoLectura;

    @Before
    public void onInit(){
        permisoFactory = new PermisoFactoryMethod();
        permisoLectura = permisoFactory.createPermiso("lectura");
    }

    @Test
    public void testPermisoLectura() {
        permisoLectura.aplicarPermiso();
        Assert.assertEquals("Permiso Lectura",permisoLectura.nombrePermiso);
        Assert.assertTrue(permisoLectura.estadoPermiso);
    }
}