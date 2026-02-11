package com.kt.MascotasMaravilla.controller;

import com.kt.MascotasMaravilla.dto.PersonaDTO;
import com.kt.MascotasMaravilla.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody PersonaDTO personaDTO) {
        personaService.crear(personaDTO);
        return ResponseEntity.ok("Persona Creada");
    }

    @GetMapping("/list")
    public List<PersonaDTO> lista() {

        return personaService.lista();
    }

    @GetMapping("/list/{id}")
    public PersonaDTO listaIdDto(@PathVariable int id) {

        return personaService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id,
                                             @RequestBody PersonaDTO personaDTO) {
        personaService.editar(id, personaDTO);
        return ResponseEntity.ok("Persona Actualizada");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        personaService.borrar(id);
        return ResponseEntity.ok("Persona Eliminada");
    }
}
