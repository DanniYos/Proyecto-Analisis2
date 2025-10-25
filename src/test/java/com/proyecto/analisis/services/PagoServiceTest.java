package com.proyecto.analisis.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PagoServiceTest {


    private Procesador procesador;
    private String resultado;

    @Before
    public void setUp() {
        procesador = new ProcesadorGT();
        resultado = new String();
    }

    @Test
    public void testEfectivo() {
        procesador.setMetodoPago(new Efectivo());
        resultado = procesador.procesarPago(15.0);
        Assert.assertEquals("Procesador GT : Pago con efectivo exitoso, monto: 15.0", resultado);
    }

    @Test
    public void testPayPal(){
        procesador.setMetodoPago(new PayPal());
        resultado = procesador.procesarPago(20.0);
        Assert.assertEquals("Procesador GT : Pago con PayPal exitoso, monto: 20.0", resultado);
    }

    @Test
    public void testTarjetaCredito(){
        procesador.setMetodoPago(new TarjetaCredito());
        resultado = procesador.procesarPago(30.0);
        Assert.assertEquals("Procesador GT : Pago con tarjeta de credito exitoso, monto: 30.0", resultado);
    }

    @Test
    public void testTarjetaDebito(){
        procesador.setMetodoPago(new TarjetaDebito());
        resultado = procesador.procesarPago(40.0);
        Assert.assertEquals("Procesador GT : Pago con tarjeta de debito exitoso, monto: 40.0", resultado);
    }

}