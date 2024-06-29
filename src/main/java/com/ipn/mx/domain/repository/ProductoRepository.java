package com.ipn.mx.domain.repository;

import com.ipn.mx.domain.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query(value = "select * from spProductosCategoria()", nativeQuery = true)
    public List<Object[]> contarProductosCategoria();
}
