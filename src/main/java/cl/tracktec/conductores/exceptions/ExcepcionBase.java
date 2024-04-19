package cl.tracktec.conductores.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error desconocido.")
public class ExcepcionBase extends RuntimeException{

    public ExcepcionBase(String errorMessage){super(errorMessage);}

    public ExcepcionBase(String errorMessage, Throwable error){super(errorMessage,error);}
}
