package cl.tracktec.conductores.controllers;

import cl.tracktec.conductores.dto.response.ConductorDTOResponse;
import cl.tracktec.conductores.services.ConductorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private final ConductorService conductorService;

    public TestController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    @GetMapping()
    public ResponseEntity<List<ConductorDTOResponse>> test(){
        List<ConductorDTOResponse> response = conductorService.findAll();
        return new ResponseEntity(response,HttpStatus.OK);
    }
}
