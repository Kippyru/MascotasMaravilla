package com.kt.MascotasMaravilla.mapper;

import com.kt.MascotasMaravilla.dto.CategoriaDTO;
import com.kt.MascotasMaravilla.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria toEntity(CategoriaDTO categoriaDTO);

    CategoriaDTO toDto(Categoria categoria);

    List<CategoriaDTO> toList(List<Categoria> categoriaList);

    void updateCategoria(CategoriaDTO categoriaDTO, @MappingTarget Categoria categoria);
}
