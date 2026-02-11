package com.kt.MascotasMaravilla.mapper;

import com.kt.MascotasMaravilla.dto.ArticuloDTO;
import com.kt.MascotasMaravilla.model.Articulo;
import com.kt.MascotasMaravilla.model.Categoria;
import com.kt.MascotasMaravilla.repository.CategoriaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ArticuloMapper {
    @Autowired
    protected CategoriaRepository categoriaRepository;

    @Mapping(target = "idCategoria", source = "idCategoria", qualifiedByName = "mapidToCategoria")
    public abstract Articulo toEntity(ArticuloDTO articuloDTO);

    @Mapping(target = "idCategoria", source = "idCategoria")
    public abstract ArticuloDTO toDto(Articulo articulo);

    @Named("mapidToCategoria")
    protected Categoria mapidToCategoria(Integer idCategoria) {
        if (idCategoria == null) return null;
        return categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    @Mapping(target = "idCategoria", source = "idCategoria", qualifiedByName = "mapidToCategoria")
    public abstract void updateArticulo(ArticuloDTO articuloDTO, @MappingTarget Articulo entity);

    public abstract List<ArticuloDTO> articuloList(List<Articulo> articulos);

}
