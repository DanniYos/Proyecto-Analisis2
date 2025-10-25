package com.proyecto.analisis.services;
import com.proyecto.analisis.entities.Producto;
import com.proyecto.analisis.repository.ProductoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;
    @InjectMocks
    private ProductoService productoService;

    private Producto producto;

    @Before
    public void onInit(){
        MockitoAnnotations.initMocks(this);
        producto = new Producto(1,"Reloj", "1234", "/path", 15.0);
    }


    @Test
    public void testFindAll() {
        when(productoRepository.findAll()).thenReturn(Arrays.asList(producto));
        List<Producto> productos = productoService.findAll();
        assertNotNull(productos);
        assertEquals(productos.size(), 1);
        assertEquals(productos.get(0).getIdProducto(), 1);
    }

    @Test
    public void testFindById() {
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));
        Producto prd = productoService.findById(1L);
        Assert.assertEquals(prd.getIdProducto(), 1);
        verify(productoRepository, times(1)).findById(1L);
    }
}