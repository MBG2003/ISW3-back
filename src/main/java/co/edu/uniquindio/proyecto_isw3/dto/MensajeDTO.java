package co.edu.uniquindio.proyecto_isw3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class MensajeDTO<T> {

    private HttpStatus status;

    private boolean error;

    private T message;

    private T response;
}
