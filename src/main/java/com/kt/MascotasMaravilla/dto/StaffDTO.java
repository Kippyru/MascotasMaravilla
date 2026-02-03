package com.kt.MascotasMaravilla.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {
    private Integer id;
    private Integer idPersona;
    private String rol;
    private String matricula;
    private Instant creado;
    private Instant editado;
}