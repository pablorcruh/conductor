package cl.tracktec.conductores.controllers;

import cl.tracktec.conductores.dto.response.ConductorDTOResponse;
import cl.tracktec.conductores.services.ConductorService;
import kong.unirest.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/conductor")
public class ConductorController {

    private final ConductorService conductorService;

    public ConductorController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    @GetMapping(value = "/healthcheck")
    public ResponseEntity<String> healthCheck() {
        log.debug("Healthcheck");
        return new ResponseEntity<>("{ \"respuesta\" : \"Estoy vivo !!!\"}", HttpStatus.OK);
    }

    @PostMapping("/conductor1")
    public ResponseEntity<String> getDataConductor(
            @RequestBody String body
    ){
        JSONObject conductorRequest = new JSONObject(body);
        JSONObject conductorResponse = new JSONObject();
        String codigoIdentificacion = conductorRequest.getString("personId");
        ConductorDTOResponse conductor = conductorService.getConductorByCodigoIdentificacion(codigoIdentificacion);
        conductorResponse.put("conductor",conductor.getApellido());
        return new ResponseEntity<>(conductorResponse.toString(), HttpStatus.OK);
    }
}
