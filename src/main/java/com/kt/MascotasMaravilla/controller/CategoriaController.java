package com.kt.MascotasMaravilla.controller;

import com.kt.MascotasMaravilla.dto.CategoriaDTO;
import com.kt.MascotasMaravilla.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.crear(categoriaDTO);
        return ResponseEntity.ok("Categoria Creada");
    }

    @GetMapping("/list")
    public List<CategoriaDTO> lista() {

        return categoriaService.lista();
    }

    @GetMapping("/list/{id}")
    public CategoriaDTO listaIdDto(@PathVariable int id) {
        return categoriaService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id,
                                             @RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.editar(id, categoriaDTO);
        return ResponseEntity.ok("Categoria Actualizada");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        categoriaService.borrar(id);
        return ResponseEntity.ok("Categoria Eliminada");
    }
}
