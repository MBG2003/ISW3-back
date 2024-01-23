package co.edu.uniquindio.proyecto_isw3.dto.get;

import co.edu.uniquindio.proyecto_isw3.modelo.EstadoSolicitud;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ReservaGetDTO {

    private int idReserva;

    private String idFacultad;

    private String idAula;

    private String emisor;

    private String asunto;

    private String descripcion;

    private EstadoSolicitud estado;

    private Date fecha;

    private int horaInicio;

    private int horaFin;

    private String observaciones;
}
