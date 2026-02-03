package com.kt.MascotasMaravilla.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private Integer idPersona;
    private String usuario;
    private String contrasena;
    private Boolean activo;
}
