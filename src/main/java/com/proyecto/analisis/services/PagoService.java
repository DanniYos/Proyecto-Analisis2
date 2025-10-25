package com.proyecto.analisis.services;
import org.springframework.stereotype.Service;

@Service
public class PagoService {

    private Procesador procesador;
    public PagoService() {
        procesador = new ProcesadorUSA();
    }

    public String procesarPago(double monto, String tipo) {
        if(tipo.equals("cash")){
            procesador.setMetodoPago(new Efectivo());
            return procesador.procesarPago(monto);
        }else if (tipo.equals("paypal")){
            procesador.setMetodoPago(new PayPal());
            return procesador.procesarPago(monto);
        }else if (tipo.equals("debit-card")){
            procesador.setMetodoPago(new TarjetaDebito());
            return procesador.procesarPago(monto);
        }else if (tipo.equals("credit-card")){
            procesador.setMetodoPago(new TarjetaCredito());
            return procesador.procesarPago(monto);
        }
        return "Metodo de pago incorrecto";
    }


}
