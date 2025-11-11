package com.vitalco.api.service;

import com.vitalco.api.exception.ResourceNotFoundException;
import com.vitalco.api.model.RutaDistribucion;
import com.vitalco.api.repository.RutaDistribucionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RutaDistribucionService {

    private final RutaDistribucionRepository rutaDistribucionRepository;

    public List<RutaDistribucion> findAll() {
        return rutaDistribucionRepository.findAll();
    }

    public RutaDistribucion findById(Long id) {
        return rutaDistribucionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("RutaDistribucion", id));
    }

    public RutaDistribucion create(RutaDistribucion rutaDistribucion) {
        rutaDistribucion.setId(null);
        return rutaDistribucionRepository.save(rutaDistribucion);
    }

    public RutaDistribucion update(Long id, RutaDistribucion rutaDistribucion) {
        RutaDistribucion existente = findById(id);
        rutaDistribucion.setId(existente.getId());
        return rutaDistribucionRepository.save(rutaDistribucion);
    }

    public void delete(Long id) {
        RutaDistribucion existente = findById(id);
        rutaDistribucionRepository.delete(existente);
    }
}
