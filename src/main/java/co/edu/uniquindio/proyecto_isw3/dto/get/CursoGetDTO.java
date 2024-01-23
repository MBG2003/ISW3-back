package co.edu.uniquindio.proyecto_isw3.dto.get;

import co.edu.uniquindio.proyecto_isw3.modelo.RecursoAV;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class CursoGetDTO {

    private String idFacultad;

    private String idPrograma;

    private String idCurso;

    private String idDocente;

    private String nombre;

    private String pensum;

    private int creditos;

    private int nivel;

    private int horas;

    private List<CursoGrupoGetDTO> grupos;

    private Set<RecursoAV> recursos;
}
