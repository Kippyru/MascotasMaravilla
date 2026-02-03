package com.kt.MascotasMaravilla.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona idPersona;

    @Column(name = "usuario", nullable = false, length = 32)
    private String usuario;

    @Column(name = "contrasena", nullable = false, length = 72)
    private String contrasena;

    @Column(name = "activo", nullable = false)
    private Boolean activo;


}