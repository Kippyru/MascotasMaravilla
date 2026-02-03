package com.kt.MascotasMaravilla.repository;

import com.kt.MascotasMaravilla.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
}