package com.kt.MascotasMaravilla.mapper;

import com.kt.MascotasMaravilla.dto.ClienteDTO;
import com.kt.MascotasMaravilla.model.Cliente;
import com.kt.MascotasMaravilla.model.Persona;
import com.kt.MascotasMaravilla.repository.PersonaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {
    @Autowired
    protected PersonaRepository personaRepository;

    @Mapping(target = "idPersona", source = "idPersona", qualifiedByName = "mapToIdPersona")
    public abstract Cliente toEntity(ClienteDTO clienteDTO);

    @Mapping(target = "idPersona", source = "idPersona")
    public abstract ClienteDTO toDto(Cliente cliente);

    @Named("mapToIdPersona")
    protected Persona mapToIdPersona(Integer idPersona) {
        if (idPersona == null) return null;
        return personaRepository.findById(idPersona)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Mapping(target = "idPersona", source = "idPersona", qualifiedByName = "mapToIdPersona")
    public abstract void updateCliente(ClienteDTO clienteDTO, @MappingTarget Cliente entity);

    public abstract List<ClienteDTO> clienteList(List<Cliente> clientes);
}
