package com.kt.MascotasMaravilla.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "turno")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTurno", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idMascota", nullable = false)
    private Mascota idMascota;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idStaff", nullable = false)
    private Staff idStaff;

    @Column(name = "fechaHora", nullable = false)
    private Instant fechaHora;

    @Column(name = "motivo", nullable = false)
    private String motivo;

    @Column(name = "estado", nullable = false, length = 32)
    private String estado;


}