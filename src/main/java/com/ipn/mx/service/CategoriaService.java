package com.ipn.mx.service;

import com.ipn.mx.domain.entity.Categoria;

import java.util.List;

public interface CategoriaService {
    public List<Categoria> findAll();
    public Categoria findById(Long id);
    public Categoria save(Categoria categoria);
    public void delete(Long id);
}
