package com.proyecto.analisis.services;

import com.proyecto.analisis.entities.Carrito;
import com.proyecto.analisis.entities.Producto;
import com.proyecto.analisis.repository.CarritoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CarritoServiceTest {

    @Mock
    private CarritoRepository carritoRepository;

    @InjectMocks
    private CarritoService carritoService;

    private Carrito carrito;
    private Producto producto;

    @Before
    public void onInit(){
        MockitoAnnotations.initMocks(this);
        carrito = new Carrito();
        carrito.setIdProducto(1);
        carrito.setCantidad(3);
        carrito.setCodUsuario("1234");
        carrito.setIdShoppingCart(15);
        producto = new Producto(1,"Reloj", "1234", "/path", 15.0);
        carrito.setProducto(producto);
    }


    @Test
    public void testAgregarProducto() {
        when(carritoRepository.save(any(Carrito.class))).thenReturn(carrito);
        Carrito resultado = carritoService.agregarProducto(producto, "1234");
        Assert.assertNotNull(resultado);
        Assert.assertEquals(producto.getIdProducto(), resultado.getIdProducto());
        Assert.assertEquals(1, resultado.getCantidad());
        verify(carritoRepository, times(1)).save(any(Carrito.class));
        verify(carritoRepository,  times(1)).getProductoByUser("1234", 1);
        verify(carritoRepository, never()).actualizarCantidad("1234", 1, 1);
    }

    @Test
    public void testEliminarProducto() {
        when(carritoRepository.getProductoByUser("1234", 1)).thenReturn(carrito);
        carritoService.eliminarProducto(1, "1234");
        verify(carritoRepository, times(1)).eliminarProducto(1, "1234");
    }

    @Test
    public void testObtenerProductos() {
        when(carritoRepository.getProductos("12345")).thenReturn(Arrays.asList(carrito));
        List<Carrito> resultado = carritoService.obtenerProductos("12345");
        Assert.assertNotNull(resultado);
        Assert.assertEquals(1, resultado.size());
    }

    @Test
    public void testVaciarCarrito() {
        carritoService.vaciarCarrito("1234");
        verify(carritoRepository, times(1)).vaciarCarrito("1234");
    }

    @Test
    public void testActualizarCantidad() {
        carritoService.actualizarCantidad("1234", 1, 5);
        verify(carritoRepository, times(1)).actualizarCantidad("1234", 1, 5);
    }
}