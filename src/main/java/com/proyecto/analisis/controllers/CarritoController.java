package com.proyecto.analisis.controllers;

import com.proyecto.analisis.entities.Carrito;
import com.proyecto.analisis.entities.Producto;
import com.proyecto.analisis.services.CarritoService;
import com.proyecto.analisis.services.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public ResponseEntity<List<Carrito>> getProductos(HttpSession session){
        String codUsuario = (String) session.getAttribute("codUsuario");
        if (codUsuario == null) {
            codUsuario = UUID.randomUUID().toString();
            session.setAttribute("codUsuario", codUsuario);
        }
        List<Carrito> carrito = carritoService.obtenerProductos(codUsuario);
        return ResponseEntity.ok(carrito);
    }


    @PostMapping("/agregar")
    public ResponseEntity<Void> agregarProducto(@RequestBody Producto producto, HttpSession session) {
        String codUsuario = (String) session.getAttribute("codUsuario");
        if (codUsuario == null) {
            codUsuario = UUID.randomUUID().toString();
            session.setAttribute("codUsuario", codUsuario);
        }
        Carrito carrito= carritoService.agregarProducto(producto, codUsuario);
        return ResponseEntity.noContent().build();
    }

    //Eliminar productos por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id, HttpSession session) {
        String codUsuario = (String)  session.getAttribute("codUsuario");
        if (codUsuario == null) {
            codUsuario = UUID.randomUUID().toString();
            session.setAttribute("codUsuario", codUsuario);
        }
        carritoService.eliminarProducto(id, codUsuario);
        return ResponseEntity.noContent().build();
    }

    //Vaciar carrito
    @DeleteMapping("/vaciar")
    public ResponseEntity<Void> vaciarCarrito (HttpSession session) {
        String codUsuario = (String)  session.getAttribute("codUsuario");
        if (codUsuario == null) {
            codUsuario = UUID.randomUUID().toString();
            session.setAttribute("codUsuario", codUsuario);
        }
        carritoService.vaciarCarrito(codUsuario);
        return ResponseEntity.noContent().build();
    }


    //Actualiza la cantidad de productos
    @PatchMapping("/actualizar-cantidad")
    public ResponseEntity<Void> actualizarCantidad(@RequestBody Carrito carrito, HttpSession session) {
        String codUsuario = (String)  session.getAttribute("codUsuario");
        if (codUsuario == null) {
            codUsuario = UUID.randomUUID().toString();
            session.setAttribute("codUsuario", codUsuario);
        }
        carritoService.actualizarCantidad(codUsuario,carrito.getIdProducto(), carrito.getCantidad());
        return ResponseEntity.noContent().build();
    }
}
