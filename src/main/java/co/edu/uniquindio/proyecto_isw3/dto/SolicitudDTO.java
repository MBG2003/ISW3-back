package co.edu.uniquindio.proyecto_isw3.dto;

import co.edu.uniquindio.proyecto_isw3.modelo.EstadoSolicitud;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class SolicitudDTO {

    @NotEmpty(message = "{solicitud.emisor.vacio}")
    private String emisor;

    private int idSolicitud;

    @NotEmpty(message = "{solicitud.facultad.vacio}")
    private String idFacultad;

    @NotEmpty(message = "{solicitud.aula.vacio}")
    private String idAula;

    @NotEmpty(message = "{solicitud.descripcion.vacio}")
    @Length(max = 2000, message = "{solicitud.descripcion.tamax}")
    private String descripcion;

    @Length(max = 1000, message = "{solicitud.observacion.tamax}")
    private String observaciones;

    private EstadoSolicitud estado;
}
