package com.kt.MascotasMaravilla.mapper;

import com.kt.MascotasMaravilla.dto.VentaDTO;
import com.kt.MascotasMaravilla.model.Cliente;
import com.kt.MascotasMaravilla.model.Venta;
import com.kt.MascotasMaravilla.repository.ClienteRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class VentaMapper {
    @Autowired
    protected ClienteRepository clienteRepository;

    @Mapping(target = "idCliente", source = "idCliente", qualifiedByName = "mapToIdCliente")
    public abstract Venta toEntity(VentaDTO ventaDTO);

    @Mapping(target = "idCliente", source = "idCliente")
    public abstract VentaDTO toDto(Venta venta);

    @Named("mapToIdCliente")
    protected Cliente mapToIdCliente(Integer idCliente){
        if (idCliente == null) return null;
        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Mapping(target = "idCliente", source = "idCliente", qualifiedByName = "mapToIdCliente")
    public abstract void updateVenta(VentaDTO ventaDTO, @MappingTarget Venta entity);

    public abstract List<VentaDTO> ventaList(List<Venta> ventas);

}
