package com.proyecto.analisis.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ProductoTest {

    private Producto producto;

    @Before
    public void onInit(){
        producto = new  Producto(1,"Reloj", "1234", "/path", 15.0);
    }


    @Test
    public void testToString() {
        String esperado = "Producto(idProducto=1, nombre=Reloj, codigo=1234, imagen=/path, precio=15.0)";
        Assert.assertEquals(esperado, producto.toString());
    }
}