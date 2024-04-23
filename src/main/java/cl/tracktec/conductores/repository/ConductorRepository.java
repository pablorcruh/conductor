package cl.tracktec.conductores.repository;

import cl.tracktec.conductores.models.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConductorRepository extends JpaRepository<Conductor, UUID> {

    Conductor findByCodigoIdentificacion(String codigoIdentificacion);
}
