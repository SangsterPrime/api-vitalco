package com.vitalco.api.controller;

import com.vitalco.api.model.RutaDistribucion;
import com.vitalco.api.service.RutaDistribucionService;
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
@RequestMapping("/api/rutas-distribucion")
@RequiredArgsConstructor
public class RutaDistribucionController {

    private final RutaDistribucionService rutaDistribucionService;

    @GetMapping
    public List<RutaDistribucion> getAll() {
        return rutaDistribucionService.findAll();
    }

    @GetMapping("/{id}")
    public RutaDistribucion getById(@PathVariable Long id) {
        return rutaDistribucionService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RutaDistribucion create(@RequestBody RutaDistribucion rutaDistribucion) {
        return rutaDistribucionService.create(rutaDistribucion);
    }

    @PutMapping("/{id}")
    public RutaDistribucion update(@PathVariable Long id, @RequestBody RutaDistribucion rutaDistribucion) {
        return rutaDistribucionService.update(id, rutaDistribucion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        rutaDistribucionService.delete(id);
    }
}
