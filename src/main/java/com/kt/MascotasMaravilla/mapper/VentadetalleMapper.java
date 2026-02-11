package com.kt.MascotasMaravilla.mapper;

import com.kt.MascotasMaravilla.dto.VentadetalleDTO;
import com.kt.MascotasMaravilla.model.Articulo;
import com.kt.MascotasMaravilla.model.Venta;
import com.kt.MascotasMaravilla.model.Ventadetalle;
import com.kt.MascotasMaravilla.repository.ArticuloRepository;
import com.kt.MascotasMaravilla.repository.VentaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class VentadetalleMapper {
    @Autowired
    protected VentaRepository ventaRepository;
    @Autowired
    protected ArticuloRepository articuloRepository;

    @Mapping(target = "idVenta", source = "idVenta", qualifiedByName = "mapIdToVenta")
    @Mapping(target = "idArticulo", source = "idArticulo", qualifiedByName = "mapIdToArticulo")
    public abstract Ventadetalle toEntity(VentadetalleDTO ventadetalleDTO);

    @Mapping(target = "idVenta", source = "idVenta")
    @Mapping(target = "idArticulo", source = "idArticulo")
    public abstract VentadetalleDTO toDto(Ventadetalle ventadetalle);

    @Named("mapIdToVenta")
    protected Venta mapIdToVenta(Integer idVenta) {
        if (idVenta == null) return null;
        return ventaRepository.findById(idVenta)
                .orElseThrow(() -> new RuntimeException("Venta no entontrada"));
    }

    @Named("mapIdToArticulo")
    protected Articulo mapIdToArticulo(Integer idArticulo) {
        if (idArticulo == null) return null;
        return articuloRepository.findById(idArticulo)
                .orElseThrow(() -> new RuntimeException("Articulo no entontrado"));
    }

    @Mapping(target = "idVenta", source = "idVenta", qualifiedByName = "mapIdToVenta")
    @Mapping(target = "idArticulo", source = "idArticulo", qualifiedByName = "mapIdToArticulo")
    public abstract void updateVentaDetalle(VentadetalleDTO ventadetalleDTO, @MappingTarget Ventadetalle entity);

    public abstract List<VentadetalleDTO> ventadetalleList(List<Ventadetalle> ventadetalles);

}
