package com.kt.MascotasMaravilla.service;

import com.kt.MascotasMaravilla.dto.PersonaDTO;
import com.kt.MascotasMaravilla.model.Persona;
import com.kt.MascotasMaravilla.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;


    public void crear(PersonaDTO personaDTO) {

        Persona persona = new Persona();
        persona.setDni(personaDTO.getDni());
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setTelefono(personaDTO.getTelefono());
        persona.setEmail(personaDTO.getEmail());
        personaRepository.save(persona);
    }

    public List<Persona> lista(){
        return personaRepository.findAll();
    }

    public Persona listaId(int id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    public void update(int id, PersonaDTO personaDTO) {
        Persona persona = listaId(id);
        persona.setDni(personaDTO.getDni());
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setTelefono(personaDTO.getTelefono());
        persona.setEmail(personaDTO.getEmail());
        personaRepository.save(persona);
    }

    public void delete(int id){
        personaRepository.deleteById(id);
    }
}
