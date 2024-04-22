package cl.tracktec.conductores.services;

import cl.tracktec.conductores.dto.converter.ConductorConverter;
import cl.tracktec.conductores.dto.response.ConductorDTOResponse;
import cl.tracktec.conductores.models.Conductor;
import cl.tracktec.conductores.repository.ConductorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConductorServiceImpl implements ConductorService{

    private final ConductorRepository conductorRepository;
    private final ConductorConverter conductorConverter;
    public ConductorServiceImpl(ConductorRepository conductorRepository, ConductorConverter conductorConverter) {
        this.conductorRepository = conductorRepository;
        this.conductorConverter = conductorConverter;
    }


    @Override
    public List<ConductorDTOResponse> findAll() {
        List<Conductor> conductores = conductorRepository.findAll();
        List<ConductorDTOResponse> response = conductores.stream()
                .map(conducutor -> this.conductorConverter.conductorDTOResponse(conducutor)).collect(Collectors.toList());
        return response;
    }
}
