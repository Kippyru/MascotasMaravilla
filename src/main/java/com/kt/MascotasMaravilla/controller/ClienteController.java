package com.kt.MascotasMaravilla.controller;

import com.kt.MascotasMaravilla.dto.ClienteDTO;
import com.kt.MascotasMaravilla.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody ClienteDTO clienteDTO) {
        clienteService.crear(clienteDTO);
        return ResponseEntity.ok("Cliente Creado");
    }

    @GetMapping("/list")
    public List<ClienteDTO> lista() {

        return clienteService.lista();
    }

    @GetMapping("/list/{id}")
    public ClienteDTO listaIdDto(@PathVariable int id) {

        return clienteService.listaId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id,
                                             @RequestBody ClienteDTO clienteDTO) {
        clienteService.editar(id, clienteDTO);
        return ResponseEntity.ok("Cliente Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        clienteService.borrar(id);
        return ResponseEntity.ok("Cliente Eliminado");
    }
}
