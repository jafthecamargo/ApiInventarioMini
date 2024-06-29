package com.ipn.mx.service;

import com.ipn.mx.domain.dto.ProductosCategoria;
import com.ipn.mx.domain.entity.Producto;

import java.util.List;

public interface ProductoService {
    public List<ProductosCategoria> ProductosCategoria();

    public List<Producto> findAll();
    public Producto findById(Long id);
    public Producto save(Producto producto);
    public void delete(Long id);
}
