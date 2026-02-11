package com.kt.MascotasMaravilla.controller;

import com.kt.MascotasMaravilla.dto.VentadetalleDTO;
import com.kt.MascotasMaravilla.service.VentadetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventadetaller")
public class VentadetalleController {

    @Autowired
    private VentadetalleService ventadetalleService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody VentadetalleDTO dto) {
        ventadetalleService.crear(dto);
        return ResponseEntity.ok("Ventadetalle Creado");
    }

    @GetMapping("/list")
    public List<VentadetalleDTO> lista() {
        return ventadetalleService.lista();
    }

    @GetMapping("/list/{id}")
    public VentadetalleDTO listaIdDto(@PathVariable int id) {
        return ventadetalleService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id,
                                             @RequestBody VentadetalleDTO dto) {
        ventadetalleService.editar(id, dto);
        return ResponseEntity.ok("Ventadetalle Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        ventadetalleService.borrar(id);
        return ResponseEntity.ok("Ventadetalle Eliminado");
    }
}