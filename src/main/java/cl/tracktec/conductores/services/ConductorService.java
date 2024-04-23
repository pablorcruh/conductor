package cl.tracktec.conductores.services;

import cl.tracktec.conductores.dto.response.ConductorDTOResponse;
import cl.tracktec.conductores.models.Conductor;

import java.util.List;

public interface ConductorService {
    List<ConductorDTOResponse> findAll();

    ConductorDTOResponse getConductorByCodigoIdentificacion(String codigoIdentificacion);
}
