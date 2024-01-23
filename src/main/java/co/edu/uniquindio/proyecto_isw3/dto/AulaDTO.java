package co.edu.uniquindio.proyecto_isw3.dto;

import co.edu.uniquindio.proyecto_isw3.modelo.EstadoAula;
import co.edu.uniquindio.proyecto_isw3.modelo.RecursoAV;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class AulaDTO {

    @NotEmpty(message = "{facultad.id.vacio}")
    private String idFacultad;

    @NotEmpty(message = "{aula.id.vacio}")
    @Length(max = 10, message = "{aula.id.tamax}")
    private String idAula;

    @NotEmpty(message = "{aula.nombre.vacio}")
    @Length(max = 10, message = "{aula.nombre.tamax}")
    private String nombre;

    private int capacidad;

    private EstadoAula estado;

    private Set<RecursoAV> recursos;
}
