package com.kt.MascotasMaravilla.mapper;

import com.kt.MascotasMaravilla.dto.UsuarioDTO;
import com.kt.MascotasMaravilla.model.Persona;
import com.kt.MascotasMaravilla.model.Usuario;
import com.kt.MascotasMaravilla.repository.PersonaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {
    @Autowired
    protected PersonaRepository personaRepository;

    @Mapping(target = "idPersona", source = "idPersona", qualifiedByName = "mapIdToPersona")
    public abstract Usuario toEntity(UsuarioDTO usuarioDTO);

    @Mapping(target = "idPersona", source = "idPersona.id")
    public abstract UsuarioDTO toDto(Usuario usuario);

    @Named("mapIdToPersona")
    protected Persona mapIdToPersona(Integer idPersona) {
        if (idPersona == null) return null;
        return personaRepository.findById(idPersona)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Mapping(target = "idPersona", source = "idPersona", qualifiedByName = "mapIdToPersona")
    public abstract void updateEntity(UsuarioDTO usuarioDTO, @MappingTarget Usuario entity);

    public abstract List<UsuarioDTO> toDtoList(List<Usuario> usuarios);
}

