package com.kt.MascotasMaravilla.service;

import com.kt.MascotasMaravilla.dto.PersonaDTO;
import com.kt.MascotasMaravilla.mapper.PersonaMapper;
import com.kt.MascotasMaravilla.model.Persona;
import com.kt.MascotasMaravilla.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private PersonaMapper personaMapper;


    public void crear(PersonaDTO personaDTO) {
        Persona persona = personaMapper.toEntity(personaDTO);
        personaRepository.save(persona);
    }

    public List<PersonaDTO> lista(){
        List<Persona> personaList = personaRepository.findAll();
        return personaMapper.toList(personaList);
    }

    public PersonaDTO listaId(int id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        return personaMapper.toDto(persona);

    }

    public PersonaDTO editar(int id, PersonaDTO personaDTO) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        personaMapper.updatePersona(personaDTO, persona);
        Persona actualizado = personaRepository.save(persona);
        return personaMapper.toDto(actualizado);
    }

    public void borrar(int id){
        if (!personaRepository.existsById(id)) {
            throw new RuntimeException("Persona no encontrada");
        }
        personaRepository.deleteById(id);
    }
}
