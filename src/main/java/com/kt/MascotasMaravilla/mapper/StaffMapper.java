package com.kt.MascotasMaravilla.mapper;

import com.kt.MascotasMaravilla.dto.StaffDTO;
import com.kt.MascotasMaravilla.model.Persona;
import com.kt.MascotasMaravilla.model.Staff;
import com.kt.MascotasMaravilla.repository.PersonaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StaffMapper {
    @Autowired
    protected PersonaRepository personaRepository;

    @Mapping(target = "idPersona", source = "idPersona", qualifiedByName = "mapIdToPersona")
    public abstract Staff toEntity(StaffDTO staffDTO);

    @Mapping(target = "idPersona", source = "idPersona.id")
    public abstract StaffDTO toDto(Staff staff);

    @Named("mapIdToPersona")
    protected Persona mapIdToPersona(Integer idPersona) {
        if (idPersona == null) return null;
        return personaRepository.findById(idPersona)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Mapping(target = "idPersona", source = "idPersona", qualifiedByName = "mapIdToPersona")
    public abstract void updateStaff(StaffDTO staffDTO, @MappingTarget Staff entity);

    public abstract List<StaffDTO> staffList(List<Staff> staffs);
}
