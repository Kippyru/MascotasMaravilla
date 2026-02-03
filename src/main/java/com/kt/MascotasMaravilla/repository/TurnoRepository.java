package com.kt.MascotasMaravilla.repository;

import com.kt.MascotasMaravilla.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
}