package com.asesoftware.turnos.repository;

import com.asesoftware.turnos.models.TurnoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Repository
public interface TurnoRepository extends JpaRepository<TurnoEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "CALL public.generarturno(:fechaInicio, :fechaFin, :idServicio)", nativeQuery = true)
    void getGenerarTurno(
            @Param("fechaInicio") Timestamp fechaInicio,
            @Param("fechaFin") Timestamp fechaFin,
            @Param("idServicio") Long idServicio
    );
}
