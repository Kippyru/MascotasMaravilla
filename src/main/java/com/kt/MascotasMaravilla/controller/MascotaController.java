package com.kt.MascotasMaravilla.controller;

import com.kt.MascotasMaravilla.dto.MascotaDTO;
import com.kt.MascotasMaravilla.dto.PersonaDTO;
import com.kt.MascotasMaravilla.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascota")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody MascotaDTO mascotaDTO) {
        mascotaService.crear(mascotaDTO);
        return ResponseEntity.ok("Mascota Creada");
    }

    @GetMapping("/list")
    public List<MascotaDTO> lista() {

        return mascotaService.lista();
    }

    @GetMapping("/list/{id}")
    public MascotaDTO listaIdDto(@PathVariable int id) {

        return mascotaService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id,
                                             @RequestBody MascotaDTO mascotaDTO) {
        mascotaService.editar(id, mascotaDTO);
        return ResponseEntity.ok("Mascota Actualizada");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        mascotaService.borrar(id);
        return ResponseEntity.ok("Mascota Eliminada");
    }
}
