package com.proyecto.analisis.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProcesadorGTTest {

    private Procesador procesadorGT;
    private String salida;

    @Before
    public void onInit() {
        procesadorGT = new ProcesadorGT();
        salida = new String();
    }

    @Test
    public void testEfectivo(){
        procesadorGT.setMetodoPago(new Efectivo());
        salida = procesadorGT.procesarPago(15.0);
        Assert.assertEquals("Procesador GT : Pago con efectivo exitoso, monto: 15.0",  salida);
    }

    @Test
    public void testPaypal(){
        procesadorGT.setMetodoPago(new PayPal());
        salida = procesadorGT.procesarPago(20.0);
        Assert.assertEquals("Procesador GT : Pago con PayPal exitoso, monto: 20.0", salida);

    }

    @Test
    public void testTarjetaCredito(){
        procesadorGT.setMetodoPago(new TarjetaCredito());
        salida = procesadorGT.procesarPago(30.0);
        Assert.assertEquals(procesadorGT.procesarPago(30.0), salida);
    }

    @Test
    public void testTarjetaDebito(){
        procesadorGT.setMetodoPago(new TarjetaDebito());
        salida = procesadorGT.procesarPago(40.0);
        Assert.assertEquals(procesadorGT.procesarPago(40.0), salida);
    }
}