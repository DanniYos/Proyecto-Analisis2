package com.proyecto.analisis.services;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class Efectivo implements MetodoPago{

    @Override
    public String pagar(double monto) {
        return "Pago con efectivo exitoso, monto: " + monto;
    }

}
