package com.vitalco.api.service;

import com.vitalco.api.exception.ResourceNotFoundException;
import com.vitalco.api.model.Cliente;
import com.vitalco.api.repository.ClienteRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente", id));
    }

    public Cliente create(Cliente cliente) {
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, Cliente cliente) {
        Cliente existente = findById(id);
        cliente.setId(existente.getId());
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        Cliente existente = findById(id);
        clienteRepository.delete(existente);
    }
}
