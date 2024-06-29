package com.ipn.mx.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Movimiento")
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimiento;

    @Column(name = "tipoMovimiento", length = 1, nullable = false)
    private String tipoMovimiento;

    @Column(name = "fechaMovimiento", nullable = false)
    private Date fechaMovimiento;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "idProducto", nullable = false)
    private Long idProducto;
}
