package com.proyecto.analisis.services;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class TarjetaDebito implements MetodoPago {
    @Override
    public String pagar(double monto) {
        return "Pago con tarjeta de debito exitoso, monto: " + monto;
    }
}
