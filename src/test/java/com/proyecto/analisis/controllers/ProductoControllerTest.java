package com.proyecto.analisis.controllers;

import com.proyecto.analisis.entities.Producto;
import com.proyecto.analisis.services.ProductoService;
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

public class ProductoControllerTest {

    @Mock
    private ProductoService productoService;
    @InjectMocks
    private ProductoController productoController;
    private Producto producto;

    @Before
    public void onInit(){
        MockitoAnnotations.initMocks(this);
        producto = new Producto(1,"Reloj", "1234", "/path", 15.0);
    }


    @Test
    public void getProductos() {
        when(productoService.findAll()).thenReturn(Arrays.asList(producto));
        ResponseEntity<List<Producto>> productos = productoController.getProductos();
        Assert.assertEquals(productos.getStatusCode(), HttpStatus.OK);
        verify(productoService, times(1)).findAll();
    }

    @Test
    public void obtenerProducto() {
        when(productoService.findById(1L)).thenReturn(producto);
        ResponseEntity<Producto> producto = productoController.obtenerProducto(1L);
        Assert.assertEquals(producto.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(1, producto.getBody().getIdProducto());
        Assert.assertEquals(0d,15.0, producto.getBody().getPrecio());
        verify(productoService, times(1)).findById(1L);
    }
}