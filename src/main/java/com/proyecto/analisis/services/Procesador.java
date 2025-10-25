package com.proyecto.analisis.services;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
public abstract class Procesador {

    protected MetodoPago metodoPago;

    public abstract String procesarPago(double monto);
}
