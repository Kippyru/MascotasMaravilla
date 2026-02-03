package com.kt.MascotasMaravilla.repository;

import com.kt.MascotasMaravilla.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
}