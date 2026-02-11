package com.kt.MascotasMaravilla.mapper;

import com.kt.MascotasMaravilla.dto.PersonaDTO;
import com.kt.MascotasMaravilla.model.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    Persona toEntity(PersonaDTO personaDTO);

    PersonaDTO toDto(Persona persona);

    List<PersonaDTO> toList(List<Persona> personaList);

    void updatePersona(PersonaDTO personaDTO, @MappingTarget Persona persona);

}

