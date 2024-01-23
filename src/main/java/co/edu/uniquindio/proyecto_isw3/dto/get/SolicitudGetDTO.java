package co.edu.uniquindio.proyecto_isw3.dto.get;

import co.edu.uniquindio.proyecto_isw3.modelo.EstadoSolicitud;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SolicitudGetDTO {

    private String emisor;

    private String idFacultad;

    private String idAula;

    private int idSolicitud;

    private String descripcion;

    private String observaciones;

    private EstadoSolicitud estado;
}
