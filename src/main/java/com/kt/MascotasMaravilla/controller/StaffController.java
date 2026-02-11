package com.kt.MascotasMaravilla.controller;

import com.kt.MascotasMaravilla.dto.StaffDTO;
import com.kt.MascotasMaravilla.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody StaffDTO staffDTO) {
        staffService.crear(staffDTO);
        return ResponseEntity.ok("Staff Creado");
    }

    @GetMapping("/list")
    public List<StaffDTO> lista() {

        return staffService.lista();
    }

    @GetMapping("/list/{id}")
    public StaffDTO listaIdDto(@PathVariable int id) {

        return staffService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id,
                                             @RequestBody StaffDTO staffDTO) {
        staffService.editar(id, staffDTO);
        return ResponseEntity.ok("Staff Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        staffService.borrar(id);
        return ResponseEntity.ok("Staff Eliminado");
    }
}
