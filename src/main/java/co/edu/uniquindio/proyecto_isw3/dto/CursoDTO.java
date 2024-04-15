package co.edu.uniquindio.proyecto_isw3.dto;

import co.edu.uniquindio.proyecto_isw3.modelo.CursoGrupo;
import co.edu.uniquindio.proyecto_isw3.modelo.Grupo;
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
public class CursoDTO {

    @NotEmpty(message = "{facultad.id.vacio}")
    private String idFacultad;

    @NotEmpty(message = "{programa.id.vacio}")
    private String idPrograma;

    @NotEmpty(message = "{curso.id.vacio}")
    @Length(max = 10, message = "{curso.id.tamax}")
    private String idCurso;

    @NotEmpty(message = "{curso.docente.vacio}")
    private String idDocente;

    @NotEmpty(message = "{curso.nombre.vacio}")
    @Length(max = 50, message = "{curso.nombre.tamax}")
    private String nombre;

    @NotEmpty(message = "{curso.pensum.vacio}")
    @Length(max = 3, message = "{curso.pensum.tamax}")
    private String pensum;

    private List<CursoGrupoDTO> grupos;

    private int creditos;

    private int nivel;

    private int horas;

    private Set<RecursoAV> recursos;
}
