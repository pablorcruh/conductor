package cl.tracktec.conductores.dto.converter;

import cl.tracktec.conductores.dto.response.ConductorDTOResponse;
import cl.tracktec.conductores.models.Conductor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConductorConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ConductorDTOResponse conductorDTOResponse(Conductor condutor){
        ConductorDTOResponse response = ConductorDTOResponse.builder()
                .rut(condutor.getRut())
                .apellido(condutor.getApellido())
                .name(condutor.getNombre())
                .build();
        return response;
    }
}
