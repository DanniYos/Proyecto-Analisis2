package com.proyecto.analisis.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idShoppingCart;
    private int idProducto;
    private String codUsuario;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
    private Producto producto; // Relación con la entidad Producto
}
