package com.ipn.mx.integration;

import com.ipn.mx.domain.dto.ProductosCategoria;
import com.ipn.mx.domain.entity.Producto;
import com.ipn.mx.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiProducto")
public class ProductoController {

    @Autowired
    ProductoService service;

    @GetMapping("/productosCategoria")
    public List<ProductosCategoria> productosCategoria() {
        return service.ProductosCategoria();
    }

    @GetMapping("/productos")
    public List<Producto> mostrarProductos() {
        return service.findAll();
    }

    @GetMapping("/productos/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/productos")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto save(@RequestBody Producto producto) {
        return service.save(producto);
    }

    @PutMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Producto update(@PathVariable Long id, @RequestBody Producto nuevoProducto) {
        Producto productoExistente = service.findById(id);
        if (productoExistente != null) {
            productoExistente.setNombreProducto(nuevoProducto.getNombreProducto());
            productoExistente.setDescripcionProducto(nuevoProducto.getDescripcionProducto());
            productoExistente.setExistencias(nuevoProducto.getExistencias());
            productoExistente.setPrecio(nuevoProducto.getPrecio());
            productoExistente.setCategoria(nuevoProducto.getCategoria());
            return service.save(productoExistente);
        } else {
            throw new RuntimeException("No se encontró el producto con el ID: " + id);
        }
    }

    @DeleteMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}