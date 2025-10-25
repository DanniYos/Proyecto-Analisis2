package com.proyecto.analisis.services;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class ProcesadorUSA extends Procesador {

    @Override
    public String procesarPago(double monto) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Procesador USA: " + metodoPago.pagar(monto);
    }
}
