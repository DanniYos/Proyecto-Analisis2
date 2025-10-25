package com.proyecto.analisis.services;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class PayPal implements MetodoPago {

    @Override
    public String pagar(double monto) {
        return "Pago con PayPal exitoso, monto: " + monto;
    }
}
