package com.kt.MascotasMaravilla.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    private Integer id;
    private Integer idCliente;
    private Instant fechaVenta;
    private BigDecimal total;
}