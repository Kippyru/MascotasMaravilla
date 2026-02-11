package com.kt.MascotasMaravilla.mapper;

import com.kt.MascotasMaravilla.dto.TurnoDTO;
import com.kt.MascotasMaravilla.model.Mascota;
import com.kt.MascotasMaravilla.model.Staff;
import com.kt.MascotasMaravilla.model.Turno;
import com.kt.MascotasMaravilla.repository.MascotaRepository;
import com.kt.MascotasMaravilla.repository.StaffRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TurnoMapper {
    @Autowired
    protected StaffRepository staffRepository;
    @Autowired
    protected MascotaRepository mascotaRepository;

    @Mapping(target = "idStaff", source = "idStaff", qualifiedByName = "mapIdToStaff")
    @Mapping(target = "idMascota", source = "idMascota", qualifiedByName = "mapIdToMascota")
    public abstract Turno toEntity(TurnoDTO turnoDTO);

    @Mapping(target = "idStaff", source = "idStaff.id")
    @Mapping(target = "idMascota", source = "idMascota.id")
    public abstract TurnoDTO toDto(Turno turno);

    @Named("mapIdToStaff")
    protected Staff mapIdToStaff(Integer idStaff) {
        if (idStaff == null) return null;
        return staffRepository.findById(idStaff)
                .orElseThrow(() -> new RuntimeException("Staff no encontrado"));
    }

    @Named("mapIdToMascota")
    protected Mascota mapIdToMascota(Integer idMascota) {
        if (idMascota == null) return null;
        return mascotaRepository.findById(idMascota)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
    }

    @Mapping(target = "idStaff", source = "idStaff", qualifiedByName = "mapIdToStaff")
    @Mapping(target = "idMascota", source = "idMascota", qualifiedByName = "mapIdToMascota")
    public abstract void updateTurno(TurnoDTO turnoDTO, @MappingTarget Turno entity);

    public abstract List<TurnoDTO> turnoList(List<Turno> turnos);

}
