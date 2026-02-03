package com.kt.MascotasMaravilla.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMascota", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente idCliente;

    @Column(name = "nombre", nullable = false, length = 32)
    private String nombre;

    @Column(name = "especie", nullable = false, length = 32)
    private String especie;

    @Column(name = "raza", nullable = false, length = 32)
    private String raza;

    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;


}