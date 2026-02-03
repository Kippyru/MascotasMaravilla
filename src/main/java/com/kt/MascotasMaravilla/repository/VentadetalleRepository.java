package com.kt.MascotasMaravilla.repository;

import com.kt.MascotasMaravilla.model.Ventadetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentadetalleRepository extends JpaRepository<Ventadetalle, Integer> {
}