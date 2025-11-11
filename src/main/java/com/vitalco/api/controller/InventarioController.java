package com.vitalco.api.controller;

import com.vitalco.api.model.Inventario;
import com.vitalco.api.service.InventarioService;
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
@RequestMapping("/api/inventarios")
@RequiredArgsConstructor
public class InventarioController {

    private final InventarioService inventarioService;

    @GetMapping
    public List<Inventario> getAll() {
        return inventarioService.findAll();
    }

    @GetMapping("/{id}")
    public Inventario getById(@PathVariable Long id) {
        return inventarioService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Inventario create(@RequestBody Inventario inventario) {
        return inventarioService.create(inventario);
    }

    @PutMapping("/{id}")
    public Inventario update(@PathVariable Long id, @RequestBody Inventario inventario) {
        return inventarioService.update(id, inventario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        inventarioService.delete(id);
    }
}
