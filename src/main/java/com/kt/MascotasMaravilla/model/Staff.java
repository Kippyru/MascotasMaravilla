package com.kt.MascotasMaravilla.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStaff", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona idPersona;

    @Column(name = "rol", nullable = false, length = 32)
    private String rol;

    @Column(name = "matricula", length = 32)
    private String matricula;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "creado", nullable = false)
    private Instant creado;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "editado", nullable = false)
    private Instant editado;


}