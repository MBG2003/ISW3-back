package co.edu.uniquindio.proyecto_isw3.dto.get;

import co.edu.uniquindio.proyecto_isw3.modelo.EstadoAula;
import co.edu.uniquindio.proyecto_isw3.modelo.RecursoAV;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class AulaGetDTO {

    private String idFacultad;

    private String idAula;

    private String nombre;

    private int capacidad;

    private EstadoAula estado;

    private Set<RecursoAV> recursos;
}
