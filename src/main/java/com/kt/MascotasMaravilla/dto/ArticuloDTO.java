package com.kt.MascotasMaravilla.dto;

import com.kt.MascotasMaravilla.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloDTO {
    private Integer id;
    private Integer idCategoria;
    private String nombreArticulo;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
}