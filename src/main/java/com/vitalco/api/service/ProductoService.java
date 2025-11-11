package com.vitalco.api.service;

import com.vitalco.api.exception.ResourceNotFoundException;
import com.vitalco.api.model.Producto;
import com.vitalco.api.repository.ProductoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto findById(Long id) {
        return productoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Producto", id));
    }

    public Producto create(Producto producto) {
        producto.setId(null);
        return productoRepository.save(producto);
    }

    public Producto update(Long id, Producto producto) {
        Producto existente = findById(id);
        producto.setId(existente.getId());
        return productoRepository.save(producto);
    }

    public void delete(Long id) {
        Producto existente = findById(id);
        productoRepository.delete(existente);
    }
}
