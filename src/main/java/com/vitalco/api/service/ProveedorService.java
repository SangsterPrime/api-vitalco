package com.vitalco.api.service;

import com.vitalco.api.exception.ResourceNotFoundException;
import com.vitalco.api.model.Proveedor;
import com.vitalco.api.repository.ProveedorRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    public Proveedor findById(Long id) {
        return proveedorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Proveedor", id));
    }

    public Proveedor create(Proveedor proveedor) {
        proveedor.setId(null);
        return proveedorRepository.save(proveedor);
    }

    public Proveedor update(Long id, Proveedor proveedor) {
        Proveedor existente = findById(id);
        proveedor.setId(existente.getId());
        return proveedorRepository.save(proveedor);
    }

    public void delete(Long id) {
        Proveedor existente = findById(id);
        proveedorRepository.delete(existente);
    }
}
