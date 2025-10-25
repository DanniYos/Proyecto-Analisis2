package com.proyecto.analisis.services;

import com.proyecto.analisis.entities.Producto;
import com.proyecto.analisis.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto findById(Long id) {
        Optional<Producto> prod =  productoRepository.findById(id);
        return prod.orElse(null);
    }
}
