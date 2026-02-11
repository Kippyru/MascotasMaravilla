package com.kt.MascotasMaravilla.mapper;

import com.kt.MascotasMaravilla.dto.MascotaDTO;
import com.kt.MascotasMaravilla.model.Cliente;
import com.kt.MascotasMaravilla.model.Mascota;
import com.kt.MascotasMaravilla.repository.ClienteRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class MascotaMapper {
    @Autowired
    protected ClienteRepository clienteRepository;

    @Mapping(target = "idCliente", source = "idCliente", qualifiedByName = "mapToIdCliente")
    public abstract Mascota toEntity(MascotaDTO mascotaDTO);

    @Mapping(target = "idCliente", source = "idCliente.id")
    public abstract MascotaDTO toDto(Mascota mascota);

    @Named("mapToIdCliente")
    protected Cliente mapToIdCliente(Integer idCliente){
        if (idCliente == null) return null;
        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Mapping(target = "idCliente", source = "idCliente", qualifiedByName = "mapToIdCliente")
    public abstract void updateMascota(MascotaDTO mascotaDTO, @MappingTarget Mascota entity);

    public abstract List<MascotaDTO> mascotaList(List<Mascota> mascotas);


}
