package com.kt.MascotasMaravilla.controller;

import com.kt.MascotasMaravilla.dto.TurnoDTO;
import com.kt.MascotasMaravilla.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody TurnoDTO dto) {
        turnoService.crear(dto);
        return ResponseEntity.ok("Turno Creado");
    }

    @GetMapping("/list")
    public List<TurnoDTO> lista() {
        return turnoService.lista();
    }

    @GetMapping("/list/{id}")
    public TurnoDTO listaIdDto(@PathVariable int id) {
        return turnoService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id,
                                             @RequestBody TurnoDTO dto) {
        turnoService.editar(id, dto);
        return ResponseEntity.ok("Turno Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        turnoService.borrar(id);
        return ResponseEntity.ok("Turno Eliminado");
    }
}