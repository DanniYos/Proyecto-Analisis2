package com.proyecto.analisis.services;

import com.proyecto.analisis.entities.Carrito;
import com.proyecto.analisis.entities.Producto;
import com.proyecto.analisis.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public Carrito agregarProducto(Producto producto, String codUsuario) {

        Carrito carr = carritoRepository.getProductoByUser(codUsuario, producto.getIdProducto());
        if(carr != null){
            carritoRepository.actualizarCantidad(codUsuario, producto.getIdProducto(),carr.getCantidad() + 1);
            return carr;
        }
        carr = new Carrito();
        carr.setIdProducto(producto.getIdProducto());
        carr.setCantidad(1);
        carr.setCodUsuario(codUsuario);
        carritoRepository.save(carr);
        return carr;
    }

    public void eliminarProducto(Integer idProducto, String codUser) {
        Carrito carr = carritoRepository.getProductoByUser(codUser, idProducto);
        if(carr != null) {
            carritoRepository.eliminarProducto(idProducto, codUser);
        }
        else {throw new RuntimeException("No existe el producto con el id: " + idProducto);};
    }

    public List<Carrito> obtenerProductos(String codUser) {
        return carritoRepository.getProductos(codUser);
    }

    public void vaciarCarrito(String codUser) {
        carritoRepository.vaciarCarrito(codUser);;
    }

    public void actualizarCantidad(String codUser, int idProducto, int cantidad) {
        carritoRepository.actualizarCantidad(codUser, idProducto, cantidad);
    }
}
