package com.vitalco.api.service;

import com.vitalco.api.exception.ResourceNotFoundException;
import com.vitalco.api.model.Empleado;
import com.vitalco.api.repository.EmpleadoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    public Empleado findById(Long id) {
        return empleadoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Empleado", id));
    }

    public Empleado create(Empleado empleado) {
        empleado.setId(null);
        return empleadoRepository.save(empleado);
    }

    public Empleado update(Long id, Empleado empleado) {
        Empleado existente = findById(id);
        empleado.setId(existente.getId());
        return empleadoRepository.save(empleado);
    }

    public void delete(Long id) {
        Empleado existente = findById(id);
        empleadoRepository.delete(existente);
    }
}
