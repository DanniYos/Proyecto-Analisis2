package com.proyecto.analisis.controllers;

import com.proyecto.analisis.entities.Carrito;
import com.proyecto.analisis.entities.Producto;
import com.proyecto.analisis.services.CarritoService;
import jakarta.servlet.http.HttpSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CarritoControllerTest {

    @Mock
    private CarritoService carritoService;
    @Mock
    private HttpSession httpSession;

    @InjectMocks
    private CarritoController carritoController;
    private Carrito carrito;
    private Producto producto;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        carrito = new Carrito();
        carrito.setIdProducto(1);
        carrito.setCantidad(3);
        carrito.setCodUsuario("1234");
        carrito.setIdShoppingCart(15);
        producto = new Producto(1,"Reloj", "1234", "/path", 15.0);
        carrito.setProducto(producto);
        when(httpSession.getAttribute("codUsuario")).thenReturn("1234");
    }

    @Test
    public void testGetProductos() {
        when(carritoService.obtenerProductos("1234")).thenReturn(Arrays.asList(carrito));
        ResponseEntity<List<Carrito>> listaCarrito = carritoController.getProductos(httpSession);
        Assert.assertEquals(1, listaCarrito.getBody().get(0).getIdProducto());
        Assert.assertEquals(1, listaCarrito.getBody().size());
        Assert.assertEquals(HttpStatus.OK, listaCarrito.getStatusCode());
        verify(carritoService, times(1)).obtenerProductos("1234");
    }

    @Test
    public void testAgregarProducto() {
        when(carritoService.agregarProducto(producto,"1234")).thenReturn(carrito);
        ResponseEntity<Void> resultado = carritoController.agregarProducto(producto,httpSession);
        Assert.assertEquals(HttpStatus.NO_CONTENT, resultado.getStatusCode());
        verify(carritoService, times(1)).agregarProducto(producto,"1234");
    }

    @Test
    public void testEliminarProducto() {
        ResponseEntity<Void> resultado = carritoController.eliminarProducto(1,httpSession);
        Assert.assertEquals(HttpStatus.NO_CONTENT, resultado.getStatusCode());
        verify(carritoService, times(1)).eliminarProducto(1, "1234");
    }

    @Test
    public void testVaciarCarrito() {
        ResponseEntity<Void> response =  carritoController.vaciarCarrito(httpSession);
        Assert.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(carritoService, times(1)).vaciarCarrito("1234");
    }

    @Test
    public void testActualizarCantidad() {
        ResponseEntity<Void> response = carritoController.actualizarCantidad(carrito, httpSession);
        Assert.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(carritoService,  times(1)).actualizarCantidad("1234", 1, 3);
    }
}