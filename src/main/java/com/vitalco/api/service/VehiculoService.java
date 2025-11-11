package com.vitalco.api.service;

import com.vitalco.api.exception.ResourceNotFoundException;
import com.vitalco.api.model.Vehiculo;
import com.vitalco.api.repository.VehiculoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo findById(Long id) {
        return vehiculoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Vehiculo", id));
    }

    public Vehiculo create(Vehiculo vehiculo) {
        vehiculo.setId(null);
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo update(Long id, Vehiculo vehiculo) {
        Vehiculo existente = findById(id);
        vehiculo.setId(existente.getId());
        return vehiculoRepository.save(vehiculo);
    }

    public void delete(Long id) {
        Vehiculo existente = findById(id);
        vehiculoRepository.delete(existente);
    }
}
