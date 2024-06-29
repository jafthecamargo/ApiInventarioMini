package com.ipn.mx.service;

import com.ipn.mx.domain.dto.ProductosCategoria;
import com.ipn.mx.domain.entity.Producto;
import com.ipn.mx.domain.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductosCategoria> ProductosCategoria() {
        List<Object[]> resultados = repository.contarProductosCategoria();
        List<ProductosCategoria> lista = new ArrayList<>();
        for (Object[] registro : resultados) {
            ProductosCategoria pc = new ProductosCategoria();
            pc.setCategoria((String) registro[0]);
            pc.setCantidad((Long) registro[1]);
            lista.add(pc);
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) repository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
