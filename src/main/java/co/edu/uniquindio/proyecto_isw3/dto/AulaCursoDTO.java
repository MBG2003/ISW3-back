package co.edu.uniquindio.proyecto_isw3.dto;

import co.edu.uniquindio.proyecto_isw3.modelo.DiaSemana;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AulaCursoDTO {

    private String idFacultadCurso;

    private String idPrograma;

    private String idCurso;

    private int idGrupo;

    private String idFacultadAula;

    private String idAula;

    private DiaSemana diaSemana;

    private int horaInicio;

    private int horaFin;
}
