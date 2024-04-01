package co.edu.uniquindio.proyecto_isw3.dto;

import co.edu.uniquindio.proyecto_isw3.modelo.DiaSemana;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HorarioGrupoDTO {

    private DiaSemana dia;

    private int horaInicio;

    private int horaFin;
}
