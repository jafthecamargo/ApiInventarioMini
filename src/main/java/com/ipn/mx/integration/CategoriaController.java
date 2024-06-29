package com.ipn.mx.integration;

import com.ipn.mx.domain.entity.Categoria;
import com.ipn.mx.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//localhost:8080/api/categorias
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CategoriaController {
    @Autowired
    CategoriaService service;

    @GetMapping("/categorias")
    public List<Categoria> readAll() {
        return service.findAll();
    }

    @GetMapping("/categorias/{id}")
    public Categoria read(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/categorias")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria create(@RequestBody Categoria categoria) {
        return service.save(categoria);
    }

    @PutMapping("/categorias/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria update(@PathVariable Long id, @RequestBody Categoria nuevaCategoria) {
        Categoria categoriaExistente = service.findById(id);
        if (categoriaExistente != null) {
            categoriaExistente.setNombreCategoria(nuevaCategoria.getNombreCategoria());
            categoriaExistente.setDescripcionCategoria(nuevaCategoria.getDescripcionCategoria());
            return service.save(categoriaExistente);
        } else {
            throw new RuntimeException("No se encontró la categoría con el ID: " + id);
        }
    }

    @DeleteMapping("/categorias/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
