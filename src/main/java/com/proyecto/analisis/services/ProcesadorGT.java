package com.proyecto.analisis.services;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class ProcesadorGT extends Procesador {

    @Override
    public String procesarPago(double monto) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Procesador GT : " + metodoPago.pagar(monto);
    }
}
