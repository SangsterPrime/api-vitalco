package com.vitalco.api.service;

import com.vitalco.api.exception.ResourceNotFoundException;
import com.vitalco.api.model.Inventario;
import com.vitalco.api.repository.InventarioRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public List<Inventario> findAll() {
        return inventarioRepository.findAll();
    }

    public Inventario findById(Long id) {
        return inventarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Inventario", id));
    }

    public Inventario create(Inventario inventario) {
        inventario.setId(null);
        inventario.setUltimaActualizacion(LocalDateTime.now());
        return inventarioRepository.save(inventario);
    }

    public Inventario update(Long id, Inventario inventario) {
        Inventario existente = findById(id);
        inventario.setId(existente.getId());
        inventario.setUltimaActualizacion(LocalDateTime.now());
        return inventarioRepository.save(inventario);
    }

    public void delete(Long id) {
        Inventario existente = findById(id);
        inventarioRepository.delete(existente);
    }
}
