package com.kt.MascotasMaravilla.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private Integer id_persona;
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate creado;
    private LocalDate editado;
}
