package co.edu.uniquindio.proyecto_isw3.dto;

import co.edu.uniquindio.proyecto_isw3.modelo.DiaSemana;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
public class CursoAulaHorarioDTO {

    private String idFacultad;

    private String idAula;

    private DiaSemana dia;

    private int horaInicio;

    private int horaFin;
}
