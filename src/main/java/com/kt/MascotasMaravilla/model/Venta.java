package com.kt.MascotasMaravilla.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente idCliente;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fechaVenta", nullable = false)
    private Instant fechaVenta;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;


}