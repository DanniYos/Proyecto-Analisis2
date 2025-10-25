package com.proyecto.analisis.controllers;
import com.proyecto.analisis.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping("/{tipoPago}/{monto}")
    public ResponseEntity<String> pagar(@PathVariable String tipoPago, @PathVariable double monto){
        String resultant = pagoService.procesarPago(monto, tipoPago);
        return ResponseEntity.ok(resultant);
    }

}
