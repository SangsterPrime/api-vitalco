package com.vitalco.api.controller;

import com.vitalco.api.model.DetallePedido;
import com.vitalco.api.service.DetallePedidoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detalles-pedido")
@RequiredArgsConstructor
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    @GetMapping
    public List<DetallePedido> getAll() {
        return detallePedidoService.findAll();
    }

    @GetMapping("/{id}")
    public DetallePedido getById(@PathVariable Long id) {
        return detallePedidoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetallePedido create(@RequestBody DetallePedido detallePedido) {
        return detallePedidoService.create(detallePedido);
    }

    @PutMapping("/{id}")
    public DetallePedido update(@PathVariable Long id, @RequestBody DetallePedido detallePedido) {
        return detallePedidoService.update(id, detallePedido);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        detallePedidoService.delete(id);
    }
}
