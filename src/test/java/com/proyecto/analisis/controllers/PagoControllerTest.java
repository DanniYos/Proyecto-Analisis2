package com.proyecto.analisis.controllers;

import com.proyecto.analisis.services.PagoService;
import com.proyecto.analisis.services.ProcesadorUSA;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PagoControllerTest {

    @Mock
    private PagoService pagoService;

    @InjectMocks
    private PagoController pagoController;

    private String salida;

    @Before
    public void onInit(){
        MockitoAnnotations.initMocks(this);
        salida = new String();
    }

    @Test
    public void pagar() {
        when(pagoService.procesarPago(15.0, "cash")).thenReturn("Efectivo");
        ResponseEntity<String> resultado = pagoController.pagar("cash", 15.0);
        Assert.assertEquals(200, resultado.getStatusCodeValue());
        verify(pagoService, times(1)).procesarPago(15.0, "cash");
    }
}