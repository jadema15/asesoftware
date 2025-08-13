package com.asesoftware.turnos.repository;

import com.asesoftware.turnos.models.TurnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<TurnoEntity, Long> {

}
