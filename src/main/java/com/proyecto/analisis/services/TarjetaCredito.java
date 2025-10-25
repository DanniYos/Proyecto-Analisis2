package com.proyecto.analisis.services;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class TarjetaCredito implements MetodoPago {

    @Override
    public String pagar(double monto) {
        return "Pago con tarjeta de credito exitoso, monto: " + monto;
    }

}
