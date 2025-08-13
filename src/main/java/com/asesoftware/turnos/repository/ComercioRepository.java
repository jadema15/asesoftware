package com.asesoftware.turnos.repository;

import com.asesoftware.turnos.models.ComercioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercioRepository extends JpaRepository<ComercioEntity, Long> {
}
