package com.proyecto.analisis.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProcesadorUSATest {

    private Procesador procesadorUSA;
    private String salida;


    @Before
    public void onInit(){
        procesadorUSA = new ProcesadorUSA();
        salida = new String();
    }

    @Test
    public void testEfectivo(){
        procesadorUSA.setMetodoPago(new Efectivo());
        salida = procesadorUSA.procesarPago(10.0);
        Assert.assertEquals("Procesador USA: Pago con efectivo exitoso, monto: 10.0", salida);
    }

    @Test
    public void testPaypal(){
        procesadorUSA.setMetodoPago(new PayPal());
        salida = procesadorUSA.procesarPago(20.0);
        Assert.assertEquals("Procesador USA: Pago con PayPal exitoso, monto: 20.0", salida);
    }

    @Test
    public void testTarjetaCredito(){
        procesadorUSA.setMetodoPago(new TarjetaCredito());
        salida = procesadorUSA.procesarPago(30.0);
        Assert.assertEquals("Procesador USA: Pago con tarjeta de credito exitoso, monto: 30.0", salida);
    }

    @Test
    public void testTarjetaDebito(){
        procesadorUSA.setMetodoPago(new TarjetaDebito());
        salida = procesadorUSA.procesarPago(40.0);
        Assert.assertEquals("Procesador USA: Pago con tarjeta de debito exitoso, monto: 40.0", salida);
    }
}