package com.ipn.mx.integration;

import com.ipn.mx.domain.dto.ProductosCategoria;
import com.ipn.mx.domain.entity.Producto;
import com.ipn.mx.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//localhost:8080/apiProducto/productosCategoria

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

    @PostMapping("/productos")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto save(@RequestBody Producto producto) {
        return service.save(producto);
    }

    @DeleteMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
