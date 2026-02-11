package com.kt.MascotasMaravilla.controller;

import com.kt.MascotasMaravilla.dto.UsuarioDTO;
import com.kt.MascotasMaravilla.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody UsuarioDTO dto) {
        usuarioService.crear(dto);
        return ResponseEntity.ok("Usuario Creado");
    }

    @GetMapping("/list")
    public List<UsuarioDTO> lista() {
        return usuarioService.lista();
    }

    @GetMapping("/list/{id}")
    public UsuarioDTO listaIdDto(@PathVariable int id) {
        return usuarioService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id,
                                             @RequestBody UsuarioDTO dto) {
        usuarioService.editar(id, dto);
        return ResponseEntity.ok("Usuario Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        usuarioService.borrar(id);
        return ResponseEntity.ok("Usuario Eliminado");
    }
}