package com.kt.MascotasMaravilla.dto;

import com.kt.MascotasMaravilla.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MascotaDTO {
    private Integer id;
    private Integer idCliente;
    private String nombre;
    private String especie;
    private String raza;
    private LocalDate fechaNacimiento;
}