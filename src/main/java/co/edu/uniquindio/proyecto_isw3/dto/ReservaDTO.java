package co.edu.uniquindio.proyecto_isw3.dto;

import co.edu.uniquindio.proyecto_isw3.modelo.EstadoSolicitud;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ReservaDTO {

    private int idReserva;

    @NotEmpty(message = "{facultad.id.vacio}")
    private String idFacultad;

    @NotEmpty(message = "{aula.id.vacio}")
    private String idAula;

    @NotEmpty(message = "{reserva.emisor.vacio}")
    private String emisor;

    @NotEmpty(message = "{reserva.asunto.vacio}")
    @Length(max = 30, message = "{reserva.asunto.tamax}")
    private String asunto;

    @NotEmpty(message = "{reserva.descripcion.vacio}")
    @Length(max = 2000, message = "{reserva.descripcion.tamax}")
    private String descripcion;

    private EstadoSolicitud estado;

    private Date fecha;

    @NotNull(message = "{reserva.hora.inicio.vacio}")
    private int horaInicio;

    @NotNull(message = "{reserva.hora.inicio.vacio}")
    private int horaFin;

    @Length(max = 1000, message = "{reserva.observaciones.tamax}")
    private String observaciones;
}
