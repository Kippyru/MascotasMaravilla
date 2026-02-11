package com.kt.MascotasMaravilla.controller;

import com.kt.MascotasMaravilla.dto.VentaDTO;
import com.kt.MascotasMaravilla.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody VentaDTO dto) {
        ventaService.crear(dto);
        return ResponseEntity.ok("Venta Creado");
    }

    @GetMapping("/list")
    public List<VentaDTO> lista() {
        return ventaService.lista();
    }

    @GetMapping("/list/{id}")
    public VentaDTO listaIdDto(@PathVariable int id) {
        return ventaService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id,
                                             @RequestBody VentaDTO dto) {
        ventaService.editar(id, dto);
        return ResponseEntity.ok("Venta Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        ventaService.borrar(id);
        return ResponseEntity.ok("Venta Eliminado");
    }
}