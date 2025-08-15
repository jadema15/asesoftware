package com.asesoftware.turnos.repository;

import com.asesoftware.turnos.models.ComercioEntity;
import com.asesoftware.turnos.models.ServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository  extends JpaRepository<ServicioEntity, Long> {
      List<ServicioEntity> findByComercio(ComercioEntity comercio);
}
