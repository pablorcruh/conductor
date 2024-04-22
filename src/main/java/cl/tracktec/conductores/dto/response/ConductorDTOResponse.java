package cl.tracktec.conductores.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConductorDTOResponse {
    private String name;
    private String apellido;
    private String rut;
}
