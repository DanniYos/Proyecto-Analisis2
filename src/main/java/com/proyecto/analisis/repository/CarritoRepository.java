package com.proyecto.analisis.repository;

import com.proyecto.analisis.entities.Carrito;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {

    @Query("SELECT c FROM Carrito c WHERE c.codUsuario = :codUser")
    List<Carrito> getProductos(String codUser);

    @Query("SELECT c FROM Carrito c WHERE c.codUsuario = :codUser AND idProducto = :productoId")
    Carrito getProductoByUser(String codUser, int productoId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Carrito WHERE idProducto = :productoId AND codUsuario = :codUser")
    void eliminarProducto(Integer productoId, String codUser);

    @Modifying
    @Transactional
    @Query("DELETE Carrito c WHERE c.codUsuario = :codUser")
    void vaciarCarrito(String codUser);

    @Modifying
    @Transactional
    @Query("UPDATE Carrito c SET c.cantidad = :cantidad WHERE c.codUsuario = :codUser AND c.idProducto = :productoId")
    void actualizarCantidad(String codUser, int productoId, int cantidad);
}
