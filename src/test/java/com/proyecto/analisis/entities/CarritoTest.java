package com.proyecto.analisis.entities;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CarritoTest {

    private Carrito carrito;

    @Before
    public void onInit(){
        carrito = new Carrito();
        carrito.setIdProducto(1);
        carrito.setCantidad(3);
        carrito.setCodUsuario("1234");
        carrito.setIdShoppingCart(15);
        carrito.setProducto(new Producto(1,"Reloj", "1234", "/path", 15.0));
    }

    @Test
    public void testToString() {
        String esperado = "Carrito(idShoppingCart=15, idProducto=1, codUsuario=1234, " +
                "cantidad=3, producto=Producto(idProducto=1, nombre=Reloj, codigo=1234, imagen=/path, precio=15.0))";
        Assert.assertEquals(esperado, carrito.toString());
    }
}