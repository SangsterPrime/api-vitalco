package com.vitalco.api.service;

import com.vitalco.api.exception.ResourceNotFoundException;
import com.vitalco.api.model.Pedido;
import com.vitalco.api.repository.PedidoRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id) {
        return pedidoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido", id));
    }

    public Pedido create(Pedido pedido) {
        pedido.setId(null);
        if (pedido.getFechaCreacion() == null) {
            pedido.setFechaCreacion(LocalDate.now());
        }
        return pedidoRepository.save(pedido);
    }

    public Pedido update(Long id, Pedido pedido) {
        Pedido existente = findById(id);
        pedido.setId(existente.getId());
        if (pedido.getFechaCreacion() == null) {
            pedido.setFechaCreacion(existente.getFechaCreacion());
        }
        return pedidoRepository.save(pedido);
    }

    public void delete(Long id) {
        Pedido existente = findById(id);
        pedidoRepository.delete(existente);
    }
}
