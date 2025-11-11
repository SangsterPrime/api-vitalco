package com.vitalco.api.service;

import com.vitalco.api.exception.ResourceNotFoundException;
import com.vitalco.api.model.DetallePedido;
import com.vitalco.api.repository.DetallePedidoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;

    public List<DetallePedido> findAll() {
        return detallePedidoRepository.findAll();
    }

    public DetallePedido findById(Long id) {
        return detallePedidoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("DetallePedido", id));
    }

    public DetallePedido create(DetallePedido detallePedido) {
        detallePedido.setId(null);
        return detallePedidoRepository.save(detallePedido);
    }

    public DetallePedido update(Long id, DetallePedido detallePedido) {
        DetallePedido existente = findById(id);
        detallePedido.setId(existente.getId());
        return detallePedidoRepository.save(detallePedido);
    }

    public void delete(Long id) {
        DetallePedido existente = findById(id);
        detallePedidoRepository.delete(existente);
    }
}
