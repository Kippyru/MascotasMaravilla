package com.kt.MascotasMaravilla.controller;

import com.kt.MascotasMaravilla.dto.ArticuloDTO;
import com.kt.MascotasMaravilla.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {
    @Autowired
    private ArticuloService articuloService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody ArticuloDTO articuloDTO) {
        articuloService.crear(articuloDTO);
        return ResponseEntity.ok("Articulo Creado");
    }

    @GetMapping("/list")
    public List<ArticuloDTO> lista() {

        return articuloService.lista();
    }

    @GetMapping("/list/{id}")
    public ArticuloDTO listaIdDto(@PathVariable int id) {

        return articuloService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id,
                                             @RequestBody ArticuloDTO articuloDTO) {
        articuloService.editar(id, articuloDTO);
        return ResponseEntity.ok("Articulo Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        articuloService.borrar(id);
        return ResponseEntity.ok("Articulo Eliminado");
    }
}
