package com.kt.MascotasMaravilla.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDTO {
    private Integer id;
    private Integer idMascota;
    private Integer idStaff;
    private Instant fechaHora;
    private String motivo;
    private String estado;
}