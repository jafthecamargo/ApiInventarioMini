package com.ipn.mx.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @NotBlank(message = "El nombre de la categoría no puede estar vacío")
    @Size(min = 4, max = 150, message = "El nombre de la categoría debe tener entre 4 y 150 caracteres")
    @Column(name = "nombreCategoria", length = 50, nullable = false)
    private String nombreCategoria;

    @NotBlank(message = "La descripción de la categoría no puede estar vacía")
    @Size(min = 4, max = 200, message = "La descripción de la categoría debe tener entre 4 y 200 caracteres")
    @Column(name = "descripcionCategoria", length = 100, nullable = false)
    private String descripcionCategoria;
}
